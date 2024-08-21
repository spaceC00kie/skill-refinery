import { useEffect, useState } from "react"
import "./App.css"

interface Fact {
  factId: number
  description: string
  title: string
}

function App() {
  const url: string = "http://localhost:8080/api"
  const [userInput, setUserInput] = useState("")
  const [facts, setFacts] = useState<Fact[]>()

  useEffect(() => {
    fetch(url)
      .then(res => res.json())
      .then(setFacts)
  }, [])

  return (
    <div>
      <div className="text-3xl font-bold">Fun Facts</div>
      <div>Search for a key word you like, and learn something cool!</div>
      <input
        className="rounded-md m-3"
        onChange={e => setUserInput(e.target.value)}
      />
      <div className="flex flex-col gap-4">
        {facts
          ?.filter(fact => fact.title.includes(userInput))
          .map(fact => (
            <div key={fact.factId} className="border rounded-md">
              <div className="font-semibold text-lg">{fact.title}</div>
              <div>{fact.description}</div>
            </div>
          ))}
      </div>
    </div>
  )
}

export default App
