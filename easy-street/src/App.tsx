import { useEffect, useState } from "react"
import "./App.css"

function App() {
  interface User {
    username: string
  }

  const url: string = "http://localhost:8080/get-user"
  const [user, setUser] = useState<User>()

  useEffect(() => {
    fetch(url)
      .then(res => res.json())
      .then(setUser)
  }, [])

  return (
    <div className="flex flex-col">
      <div>Easy</div>
      <div>{user?.username}</div>
    </div>
  )
}

export default App
