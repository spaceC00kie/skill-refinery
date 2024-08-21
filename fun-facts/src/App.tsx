import { useState } from 'react'
import './App.css'

function App() {
  const [userInput, setUserInput] = useState("")

  return (
    <div>
      <div className='text-2xl'>Fun Facts</div>
      <div className="">
        <input className='rounded-md' onChange={e => setUserInput(e.target.value)}/>
      </div>
      <div>You typed: {userInput}
      </div>
    </div>
  )
}

export default App
