import { useEffect, useState } from "react"
import "./App.css"

function App() {
  interface User {
    userName: string
    height: string
  }
  const url: string = "http://localhost:8080/posting"
  const [successMessage, setSuccessMessage] = useState("")
  const user: User = {
    userName: "K",
    height: "5'4",
  }

  useEffect(() => {
    fetch(url, { method: "POST", body: JSON.stringify(user) })
      .then(res => res.json())
      .then(setSuccessMessage)
  }, [])

  return (
    <div className="flex flex-col gap-4">
      <div>What's your name?</div>
      <div>
        <button className="border rounded-md m-2" onClick={() => {}}>click here</button>
      </div>
      <div className="">
        (this is gonna be reply from backend){successMessage}
      </div>
    </div>
  )
}

export default App
