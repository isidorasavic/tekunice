import React, { PureComponent, useState } from 'react';
import './style.css'
import CreateNewHabitat from '../../create-habitat-components/CreateNewHabitat'
import CreateNaturalFactors from '../../create-habitat-components/CreateNaturalFactors'
import Typography from '@mui/material/Typography';
import Fab from '@mui/material/Fab';
import ArrowForward from '@mui/icons-material/ArrowForward';
import ArrowBack from '@mui/icons-material/ArrowBack';
import CreateAntropologicalFactors from '../../create-habitat-components/CreateAntropologicalFactors'
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from "react-router-dom"
import Tooltip from '@mui/material/Tooltip';

const CreateHabitatPage = () => {

    const navigate = useNavigate();

    const [openForm, setOpenForm] = useState('createNew');

    const formNames = ["createNew", "naturalFactors", "antropologicalFactors"]

    const returnToDashboard = () => {
        navigate('/dashboard');
    }   

    let form;
    let title;
    if(openForm === 'createNew') {
        form = <CreateNewHabitat/>
        title = "Kreiraj ime i tip staništa"
    }
    if(openForm === 'naturalFactors') {
        form = <CreateNaturalFactors/>
        title = "Dodaj prirodne faktore staništa"
    }
    if(openForm === 'antropologicalFactors') {
        form = <CreateAntropologicalFactors addNew={false}/>
        title = "Dodaj antropološke faktore staništa"
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
                <Typography variant="h3" component="div">
                    Kreiraj novo stanište
                </Typography>
            </div>
            <div className="form-container">
                <div className="round-bttn-container">
                    <div className="round-bttn" style={{textAlign:"left"}}>
                        <Fab style={{backgroundColor:"tan"}} aria-label="add" 
                            className="arrow-back" onClick={() => {setOpenForm(formNames[formNames.indexOf(openForm)-1])}}
                            disabled={formNames.indexOf(openForm) === 0}> <ArrowBack />
                        </Fab>
                    </div>
                    <div>
                        <h2 className="form-title">{title}</h2>
                    </div>
                    <div className="round-bttn"  style={{textAlign:"right"}}>
                        <Fab style={{backgroundColor:"tan"}} aria-label="add" 
                            className="arrow-next" onClick={() => {setOpenForm(formNames[formNames.indexOf(openForm)+1])}}
                            disabled={formNames.indexOf(openForm) === formNames.length-1}
                            > <ArrowForward /> 
                        </Fab>
                    </div>
                </div>
                {form}
            </div>
        </div>
    )

}
export default CreateHabitatPage