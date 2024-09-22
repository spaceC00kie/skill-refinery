import { useEffect, useState } from "react"
import "./App.css"

interface PokemonList {
  pokemon: Pokemon[]
}

interface Pokemon {
  types: string[]
  attacks: Attacks[]
  defense: number
  attack: number
  name: string
  hp: number
  id: number
  speed: number
}

interface Attacks {
  name: string
  power: number
  type: string
}

function App() {
  const [userInput, setUserInput] = useState("")
  const [pokemonList, setPokemonList] = useState<PokemonList>()
  const url: string = "http://localhost:8080/pokemon"

  useEffect(() => {
    fetch(url)
      .then(res => res.json())
      .then(setPokemonList)
  }, [])

  return (
    <div className="flex flex-col gap-2">
      <div className="text-2xl">Pokemon!</div>
      <div>
        <input
          className="rounded-md"
          onChange={e => setUserInput(e.target.value)}
        />
      </div>
      <div className="flex flex-col items-center gap-2">
        {userInput &&
          pokemonList?.pokemon
            .filter(pokemon =>
              pokemon.name.toLowerCase().startsWith(userInput.toLowerCase())
            )
            .map(({ id, name, hp, defense, speed, attacks, types }) => (
              <div
                className="flex flex-col items-center border-2 border-stone-400 rounded-md"
                key={id}
              >
                <div className="border-b border-stone-400 font-bold text-xl">
                  {name}
                </div>
                <div className="my-1 flex">
                  (
                  {types.map(type => (
                    <div className="mx-1">{type}</div>
                  ))}
                  )
                </div>
                <div className="flex justify-evenly gap-2">
                  <div className="font-semibold">HP: {hp}</div>
                  <div className="font-semibold">Defense: {defense}</div>
                </div>
                <div className="flex">
                  <div>
                    {attacks.map(attack => (
                      <div className="my-2 mx-4">{attack.name}</div>
                    ))}
                  </div>
                  <div>
                    {attacks.map(attack => (
                      <div className="my-2">{attack.power}</div>
                    ))}
                  </div>
                  <div>
                    {attacks.map(attack => (
                      <div className="m-2">({attack.type})</div>
                    ))}
                  </div>
                </div>
                <div className="mb-2">Speed: {speed}</div>
              </div>
            ))}
      </div>
    </div>
  )
}

export default App
