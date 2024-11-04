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
  const editingUrl: string = `${baseUrl}/patch`

  const [editing, setEditing] = useState(false)
  const [name, setName] = useState("")
  const [color, setColor] = useState("")
  const [id, setId] = useState("")
  const [pokemonList, setPokemonList] = useState<Pokemon[]>()

  const handleEdit = (pokemon: Pokemon) => {
    setEditing(true)
    setName(pokemon.name)
    setColor(pokemon.color)
    setId(pokemon.id.toString())
  }

  const handleCancelEdit = () => {
    setEditing(false)
    setName("")
    setColor("")
    setId("")
  }

  const clearForm = () => {
    setName("")
    setColor("")
    setId("")
  }

  const addPokemon = () => {
    fetch(postingUrl, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ id: Number(id), name, color }),
    })
      .then(res => res.json())
      .then(setPokemonList)
      .then(() => clearForm())
  }

  const editPokemon = () => {
    fetch(editingUrl, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ id: Number(id), name, color }),
    })
      .then(res => res.json())
      .then(setPokemonList)
  }

  const deletePokemon = (id: number, name: string, color: string) => {
    fetch(deletingUrl, {
      method: "DELETE",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ id: Number(id), name, color }),
    })
      .then(res => res.json())
      .then(setPokemonList)
  }

  useEffect(() => {
    fetch(pokemonListUrl)
      .then(res => res.json())
      .then(setPokemonList)
  }, [])

  return (
    <div className="flex flex-col gap-2">
      <div>Define a new Pokemon</div>
      <div className="flex flex-col gap-1">
        <div>
          Id:
          <input
            value={id}
            type="number"
            className="rounded-md"
            onChange={e => setId(e.target.value)}
          />
        </div>
        <div>
          Name:
          <input
            value={name}
            className="rounded-md"
            onChange={e => setName(e.target.value)}
          />
        </div>
        <div>
          Color:
          <input
            value={color}
            className="rounded-md"
            onChange={e => setColor(e.target.value)}
          />
        </div>
        <div className="flex flex-col">
          <div>What you're making</div>
          <div className="">
            <div>Id: {id}</div>
            <div>Name: {name}</div>
            <div>Color: {color}</div>
          </div>
        </div>
      </div>
      {editing ? (
        <button
          className="border border-gray-400 hover:border-green-300"
          onClick={editPokemon}
        >
          Save edit
        </button>
      ) : (
        <button
          className="border border-gray-400 hover:border-green-300"
          onClick={addPokemon}
        >
          Create pokemon
        </button>
      )}
      <div className="flex flex-col gap-2">
        <div>List of all the Pokemon in our system:</div>
        {pokemonList?.map((pokemon, index) => (
          <div
            key={index}
            className="flex items-center justify-between gap-2 rounded-sm border px-2"
          >
            <div>Name: {pokemon.name}</div>
            <div>Color: {pokemon.color}</div>
            <div className="flex gap-2 align-middle">
              {!editing ? (
                <button
                  className="h-3 w-3 rounded-full border border-yellow-600 bg-yellow-500 hover:bg-yellow-800"
                  onClick={() => handleEdit(pokemon)}
                ></button>
              ) : (
                <button
                  className="h-3 w-3 rounded-full border border-yellow-600 bg-yellow-500 hover:bg-yellow-800"
                  onClick={() => handleCancelEdit()}
                ></button>
              )}
              <button
                className="h-3 w-3 rounded-full border border-red-600 bg-red-500 hover:bg-red-800"
                onClick={() =>
                  deletePokemon(pokemon.id, pokemon.name, pokemon.color)
                }
              ></button>
            </div>
          </div>
        ))}
      </div>
    </div>
  )
}

export default App
