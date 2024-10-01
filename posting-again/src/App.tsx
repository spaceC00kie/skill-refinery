import { useEffect, useState } from "react"
import "./App.css"

function App() {
  interface User {
    username: string
    coatColor: string
  }

  const createUserUrl: string = "http://localhost:8080/create-user"
  const getUserUrl: string = "http://localhost:8080/get-users"
  const [successMessage, setSuccessMessage] = useState("")
  const [user, setUser] = useState<User>()

  // to practice POST request
  const hardcodedUser: User = {
    username: "Mal",
    coatColor: "brown",
  }

  useEffect(() => {
    fetch(createUserUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(hardcodedUser),
    })
      .then(res => res.json())
      .then(message => {
        setSuccessMessage(message.yay)
        return fetch(getUserUrl)
      })
      .then(res => res.json())
      .then(data => {
        console.log(data)
        setUser({ username: data.username, coatColor: data.coatColor })
      })
  }, [])

  return (
    <div className="flex flex-col items-center">
      <div className="text-2xl underline">Create a user from Serenity's crew</div>
      <div>Tell your tale below</div>
      <div className="flex flex-col gap-1">
        <div>
          Your name: <input className="rounded-md" />
        </div>
        <div>
          Color of your coat: <input className="rounded-md" />
        </div>
      </div>
      <div>Backend response?: {successMessage}</div>
      <div className="flex flex-col">
        {user && (
          <div className="flex gap-4" key={user.username}>
            <div>Name: {user.username}</div>
            <div>Coat: {user.coatColor}</div>
          </div>
        )}
      </div>
    </div>
  )
}

export default App
