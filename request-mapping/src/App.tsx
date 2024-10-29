import { useEffect, useState } from "react"
import "./App.css"

function App() {
  interface Pokemon {
    id: number
    name: string
    color: string
  }

  const baseUrl: string = "http://localhost:8080/pokemon"

  const pokemonListUrl: string = `${baseUrl}/list`
  const postingUrl: string = `${baseUrl}/add`
  const deletingUrl: string = `${baseUrl}/delete`

  const [newPokeName, setNewPokeName] = useState("")
  const [newPokeColor, setNewPokeColor] = useState("")
  const [newPokeId, setNewPokeId] = useState<number>()
  const [pokemonList, setPokemonList] = useState<Pokemon[]>()
  const newPokemon = {
    id: newPokeId,
    name: newPokeName,
    color: newPokeColor,
  }

  function PostNewPokemon() {
    fetch(postingUrl, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newPokemon),
    })
      .then(res => res.json())
      .then(setPokemonList)
  }

  function DeletePokemon(id: number, name: string, color: string) {
    fetch(deletingUrl, {
      method: "DELETE",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ id: id, name: name, color: color }),
    })
      .then(res => res.json())
      .then(setPokemonList)
  }

  useEffect(() => {
    fetch(pokemonListUrl)
      .then(res => res.json())
      .then(setPokemonList)
  }, [pokemonList])

  return (
    <div className="flex flex-col gap-2">
      <div>Define a new Pokemon</div>
      <div className="flex flex-col gap-1">
        <div>
          Id:
          <input
            type="number"
            className="rounded-md"
            onChange={e => setNewPokeId(e.target.valueAsNumber)}
          />
        </div>
        <div>
          Name:
          <input
            className="rounded-md"
            onChange={e => setNewPokeName(e.target.value)}
          />
        </div>
        <div>
          Color:
          <input
            className="rounded-md"
            onChange={e => setNewPokeColor(e.target.value)}
          />
        </div>
        <div className="flex flex-col">
          <div>What you're making</div>
          <div className="">
            <div>Id: {newPokeId}</div>
            <div>Name: {newPokeName}</div>
            <div>Color: {newPokeColor}</div>
          </div>
        </div>
      </div>
      <button
        className="border border-gray-400 hover:border-green-300"
        onClick={PostNewPokemon}
      >
        Create pokemon
      </button>
      <div className="">
        <div>List of all the Pokemon in our system:</div>
        {pokemonList?.map((pokemon, index) => (
          <div
            key={index}
            className="flex items-center justify-between gap-2 rounded-sm border px-2"
          >
            <div>Name: {pokemon.name}</div>
            <div>Color: {pokemon.color}</div>
            <button
              className="h-3 w-3 rounded-full border border-red-600 bg-red-500 hover:bg-red-800"
              onClick={() =>
                DeletePokemon(pokemon.id, pokemon.name, pokemon.color)
              }
            ></button>
          </div>
        ))}
      </div>
    </div>
  )
}

export default App
