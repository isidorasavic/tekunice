import React, { PureComponent, useState, useEffect } from 'react';
import Typography from '@mui/material/Typography';
import Fab from '@mui/material/Fab';
import './style.css'
import * as Constants from '../../constants'
import axios from 'axios'
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from "react-router-dom"
import TextField from '@mui/material/TextField'
import InputAdornment from '@mui/material/InputAdornment';
import IconButton from '@mui/material/IconButton';
import FormControl from '@mui/material/FormControl';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import OutlinedInput from '@mui/material/OutlinedInput';
import Button from '@mui/material/Button'


const LogInPage = () => {
    const navigate = useNavigate();

    const [userCreditentials, setUserCreditentials] = useState({username:'', password:''});
    const [showPassword, setShowPassword] = useState(false);

    useEffect(()=> {
        if (sessionStorage.getItem('username') !== null){
            navigate('/dashboard');
        }
    }, [])

    const logIn = (event) => {
        event.preventDefault();
        const newUser = {
            username: userCreditentials.username,
            password: userCreditentials.password
        }
        axios.post(Constants.BasePath + 'auth/login',newUser, 
        { headers: { "Content-Type": "application/json; charset=UTF-8" },
        })
        .then(response => {
            console.log(response.data);
            sessionStorage.setItem('username', response.data.username);
            navigate('/dashboard');
        })
        .catch(error => {
            console.log(error.response);
          })
    }

    return (
        <div className="log-in-container">
            <div className="log-in-title">
                Srećne tekunice
            </div>
            <div className="log-in-subtitle">
                Log in
            </div>
            <div className="log-in-form-container">
                <form onSubmit={logIn} className="log-in-form">
                        <div className="row">
                            <TextField
                                required
                                className="input-field"
                                id="username"
                                placeholder="Korisničko ime"
                                value={userCreditentials.username} onChange={(event)=> {setUserCreditentials({...userCreditentials, username: event.target.value})}}
                            />
                        </div>
                        <div className="row">
                            <FormControl variant="outlined">
                                <OutlinedInput
                                    required
                                    className="input-field"
                                    type={showPassword ? 'text' : 'password'}
                                    value={userCreditentials.password}
                                    onChange={(event)=> {setUserCreditentials({...userCreditentials, password: event.target.value})}}
                                    endAdornment={
                                    <InputAdornment position="end">
                                        <IconButton
                                        aria-label="toggle password visibility"
                                        onClick={()=> {setShowPassword(!showPassword)}}
                                        edge="end"
                                        >
                                        {showPassword ? <VisibilityOff /> : <Visibility />}
                                        </IconButton>
                                    </InputAdornment>
                                    }
                                    placeholder="Lozinka"
                                />
                            </FormControl>
                        </div>
                        <div className="row">
                            <Button variant="outlined" sx={Constants.bttnStyle} className="log_in_submit" type="submit">Submit</Button>
                        </div>
                        <div className="row">
                            <Button id="link-bttn" className="smallButton"  sx={Constants.linkBttnStyle} component={Link} to="/registration">Kreiraj nalog</Button>
                        </div>
                    </form>
            </div>
        </div>
    )


}
export default LogInPage