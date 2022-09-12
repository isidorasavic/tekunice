import React, { PureComponent, useState, useEffect } from 'react';
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
import { SnackbarProvider, useSnackbar } from 'notistack';


const RegisterPage = () => {

    const { enqueueSnackbar } = useSnackbar();
    const navigate = useNavigate();

    const [userCreditentials, setUserCreditentials] = useState({username: '', password: '', password2: ''});
    const [showPassword, setShowPassword] = useState(false);
    const [showPassword2, setShowPassword2] = useState(false);
    
    useEffect(()=> {
        if (sessionStorage.getItem('username') !== null){
            navigate('/dashboard');
        }
    }, [])

    const register = (event) => {
        event.preventDefault();
        const newUser = {
            username: userCreditentials.username,
            password: userCreditentials.password
        }
        axios.post(Constants.BasePath + 'auth/signUp',newUser, 
        { headers: { "Content-Type": "application/json; charset=UTF-8" },
        })
        .then(response => {
            console.log(response.data);
            enqueueSnackbar('Nalog je uspesno kreiran!', {variant: 'success'});
            navigate('/login');
        })
        .catch(error => {
            console.log(error.response);
            enqueueSnackbar('Doslo je do greske!', {variant: 'error'});
            setUserCreditentials({username:'', password:'', password2:''});
          })

    }

    const isFormValid = () => {
        if (userCreditentials.password !== userCreditentials.password2) {
            return false;
        }
        if (userCreditentials.username === '' || userCreditentials.password === '' || userCreditentials.password2 === ''){
            return false;
        }
        return true;
    }

    return (
        <div className="log-in-container">
            <div className="log-in-title">
                Srećne tekunice
            </div>
            <div className="log-in-subtitle">
                Kreirajte nalog
            </div>
            <div className="log-in-form-container">
                <form onSubmit={register} className="log-in-form">
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
                            <FormControl variant="outlined">
                                <OutlinedInput
                                    required
                                    className="input-field"
                                    type={showPassword2 ? 'text' : 'password'}
                                    value={userCreditentials.password2}
                                    onChange={(event)=> {setUserCreditentials({...userCreditentials, password2: event.target.value})}}
                                    endAdornment={
                                    <InputAdornment position="end">
                                        <IconButton
                                        aria-label="toggle password visibility"
                                        onClick={()=> {setShowPassword2(!showPassword2)}}
                                        edge="end"
                                        >
                                        {showPassword2 ? <VisibilityOff /> : <Visibility />}
                                        </IconButton>
                                    </InputAdornment>
                                    }
                                    error={userCreditentials.password !== userCreditentials.password2}
                                    placeholder="Ponovite lozinku"
                                />
                            </FormControl>
                        </div>
                        <div className="row">
                            <Button variant="outlined" sx={Constants.bttnStyle} className="log_in_submit" type="submit" disabled={!isFormValid()}>Submit</Button>
                        </div>
                    </form>
            </div>
        </div>

    )
}
export default RegisterPage