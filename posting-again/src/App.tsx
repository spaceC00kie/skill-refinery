import { useEffect, useState } from "react"
import "./App.css"

function App() {
  interface User {
    username: string
    hairColor: string
  }

  const url: string = "http://localhost:8080/create-user"
  const [successMessage, setSuccessMessage] = useState("")
  const user: User = {
    username: "KD",
    hairColor: "brown",
  }

  useEffect(() => {
    console.log(JSON.stringify(user))
    fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(user),
    })
      .then(res => res.json())
      .then(message => setSuccessMessage(message.yay))
  }, [])

  return (
    <div className="flex flex-col">
      <div className="text-2xl">Let's create a user</div>
      <div>Give out your info below</div>
      <div className="flex flex-col gap-1">
        <div>
          Your name: <input className="rounded-md" />
        </div>
        <div>
          Hair color: <input className="rounded-md" />
        </div>
      </div>
      <div>(The backend response should go here): {successMessage}</div>
    </div>
  )
}

export default App
