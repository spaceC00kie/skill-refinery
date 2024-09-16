import { useEffect, useState } from "react"
import "./App.css"

function App() {
  const url: string = "http://localhost:8080/sup"
  const [userInput, setUserInput] = useState("")
  const [hello, setHello] = useState("")

  useEffect(() => {
    fetch(url)
      .then(res => res.text())
      .then(setHello)
  }, [])

  return (
    <div className="flex flex-col">
      <div>Hello!</div>
      <div>
        <input
          className="rounded-md"
          onChange={e => setUserInput(e.target.value)}
        />
      </div>
      <div>{userInput}</div>
      <div>{hello}</div>
    </div>
  )
}

export default App
