import { useEffect, useState } from "react"
import "./App.css"

function App() {
  const [userNumber, setUserNumber] = useState<number>()
  const [fibNum, setFibNum] = useState<number>()

  useEffect(() => {
    if (userNumber) {
      const url: string = `http://localhost:8080/nthfib/${userNumber}`
      fetch(url)
        .then(res => res.json())
        .then(setFibNum)
    }
  }, [userNumber])

  return (
    <div>
      <div className="text-2xl font-bold">Fib Fun!</div>
      <div>
        <input
          placeholder=" Enter a number"
          className="rounded-md"
          onChange={e => setUserNumber(parseInt(e.target.value, 10) || 0)}
        />
      </div>
      <div>Below is the value of that place in the Fibonacci sequence</div>
      <div className="text-3xl">{fibNum}</div>
    </div>
  )
}

export default App
