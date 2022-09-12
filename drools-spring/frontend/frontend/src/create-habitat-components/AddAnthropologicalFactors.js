import React, { PureComponent, useEffect, useState } from 'react';
import Typography from '@mui/material/Typography';
import CreateAntropologicalFactors from './CreateAntropologicalFactors';
import { useParams } from 'react-router-dom';
import './style.css'
import Fab from '@mui/material/Fab';
import ArrowBack from '@mui/icons-material/ArrowBack';
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from "react-router-dom"
import Tooltip from '@mui/material/Tooltip';


const AddAnthopologicalFactors = () => {

    const { habitatId } = useParams();

    useEffect(()=>{
        console.log(habitatId);
    }, [])

    const navigate = useNavigate();

    const returnToDashboard = () => {
        localStorage.clear();
        navigate('/dashboard');
    }   

    if (sessionStorage.getItem('username') === null) {
        return (
            <div>
                <h1>Unauthorized</h1>
            </div>
        )
    }

    return (
        <div className="add-habitat-container">
            <div className="header-add-af">
                <Tooltip title="Vrati se na početnu stranu">
                    <Fab style={{backgroundColor:"tan"}} className="back-bttn"  onClick={returnToDashboard}> <ArrowBack /></Fab>
                </Tooltip>
                <Typography variant="h4" component="div">
                Dodaj nove antropološke faktore
                </Typography>
            </div>
            <div className="form-container">
                <div id="add-af-form">
                <CreateAntropologicalFactors className="add-af-form"  addNew={true} habitatId={habitatId}/>                   
                </div>
            </div>
        </div>
    )

}
export default AddAnthopologicalFactors