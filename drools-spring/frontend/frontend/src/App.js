import logo from './logo.svg';
import './App.css';
import CreateHabitatPage from './pages/add-habitat-page/CreateHabitatPage'
import { BrowserRouter as Router,Routes, Route } from 'react-router-dom';
import LogInPage from '../src/pages/login-page/LogInPage'
import DashboardPage from '../src/pages/dashboard-page/DashboardPage'
import { SnackbarProvider, useSnackbar } from 'notistack';
import AddAnthopologicalFactors from './create-habitat-components/AddAnthropologicalFactors';
import RegisterPage from './pages/register-page/RegisterPage';



function App() {
  return (
    <SnackbarProvider maxSnack={6} anchorOrigin={{
      vertical: 'top',
      horizontal: 'right',
    }}>
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
                <Route path='/new-anthropological-factors/:habitatId' element={< AddAnthopologicalFactors />}></Route>
                <Route path='/registration' element={< RegisterPage />}></Route>
            </Routes>
        </Router>
      </div>
    </SnackbarProvider>

  );
}

export default App;
