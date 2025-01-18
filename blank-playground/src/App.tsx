import { useState } from "react"
import reactLogo from "./assets/react.svg"
import "./App.css"

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="flex-col gap-2">
      <div className="flex-col">
        <a
          href="https://meta.stackexchange.com/questions/184108/what-is-syntax-highlighting-and-how-does-it-work/184109#184109"
          target="_blank"
        >
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
        <div>
          Click the pretty React icon above to see the language codes available
          on Stack Overflow
        </div>
      </div>
      <div className="text-3xl">React Playground</div>
      <div className="m-2">
        <button onClick={() => setCount(count => count + 1)}>
          count is {count}
        </button>
        <p>Code-y code-y words words</p>
        <div>
          This is where I can post React code from Stack Overflow to see how it
          looks
        </div>
      </div>
    </div>
  )
}

export default App
