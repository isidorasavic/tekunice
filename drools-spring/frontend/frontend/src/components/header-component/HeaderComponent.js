import React, { PureComponent, useState, useEffect } from 'react';
import './style.css'
import * as Constants from '../../constants'
import Button from '@mui/material/Button'
import axios from 'axios'
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from "react-router-dom"


const HeaderComponent = () => {

    const navigate = useNavigate();

    const logOut = () => {
        localStorage.clear();
        sessionStorage.clear();
        axios.post(Constants.BasePath + 'auth/logout', 
        { headers: { "Content-Type": "application/json; charset=UTF-8" },
        })
        .then(response => {
            navigate('/login');
        })
        .catch(error => {
            console.log(error.response);
          })
    }

    return (
        <div className="header-div">
            <div className="logo">
                {/* <img src="icon.png" className="logo-image" alt="tekunica"/> */}
                <img src="animal-chipmunk.gif" className="logo-image" alt="tekunica"/>
                <div className="logo-title">Srećne tekunice</div>
            </div>
            <div className="dashboard-title">
                Moja staništa
            </div>
            <div className="log-out-div">
                <Button variant="outlined" sx={Constants.bttnStyle} onClick={logOut} className="log_out-bttn">Log out</Button>
            </div>
        </div>
    )
}
export default HeaderComponent;