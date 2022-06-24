import logo from './logo.svg';
import './App.css';
import CreateHabitatPage from './pages/add-habitat-page/CreateHabitatPage'
import { BrowserRouter as Router,Routes, Route } from 'react-router-dom';
import LogInPage from '../src/pages/login-page/LogInPage'
import DashboardPage from '../src/pages/dashboard-page/DashboardPage'

function App() {
  return (
    // <div className="App">
    //   <CreateHabitatPage/>
    // </div>
    <div  className="App" style={{ position:"absolute",
    top:"0px",
    right:"0px",
    bottom:"0px",
    left:"0px"}}>
    <Router>
        <Routes>
            <Route index path='/login' element={< LogInPage/>}></Route>
            <Route path='/dashboard' element={< DashboardPage/>}></Route>
            <Route path='/create-habitat' element={< CreateHabitatPage />}></Route>
        </Routes>
    </Router>
</div>

  );
}

export default App;
