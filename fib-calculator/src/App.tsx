import { useEffect, useState } from "react"
import "./App.css"

function App() {
  const url: string = "http://localhost:8080/hello-world"
  const [hello, setHello] = useState("")
  const [userInput, setUserInput] = useState<number>()

  useEffect(() => {
    fetch(url)
      .then(res => res.text())
      .then(res => setHello(res))
  }, [])

  return (
    <div className="flex flex-col items-center">
      Type a number and see the value at that place in the Fibonacci sequence
      <div className="flex flex-col max-w-24">
        <input
          type="number"
          className="rounded-md"
          onChange={e => setUserInput(e.target.valueAsNumber)}
        />
      </div>
      <div>{hello}</div>
      <div>You typed: {userInput}</div>
    </div>
  )
}

export default App
