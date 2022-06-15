import React, { PureComponent, useState } from 'react';
import './style.css'
import CreateNewHabitat from '../../components/CreateNewHabitat'
import CreateNaturalFactors from '../../components/CreateNaturalFactors'
import Typography from '@mui/material/Typography';
import Fab from '@mui/material/Fab';
import ArrowForward from '@mui/icons-material/ArrowForward';
import ArrowBack from '@mui/icons-material/ArrowBack';
import CreateAntropologicalFactors from '../../components/CreateAntropologicalFactors'

const CreateHabitatPage = () => {

    const [newHabitat, setNewHabitat] = useState({name: '', label: null})
    const [naturalFactors, setNaturalFactors] = useState();
    const [antropologicalFactors, setAntropologicalFactors] = useState();

    const [openForm, setOpenForm] = useState('createNew');

    const formNames = ["createNew", "naturalFactors", "antropologicalFactors"]

    let form;
    if(openForm === 'createNew') form = <CreateNewHabitat/>
    if(openForm === 'naturalFactors') form = <CreateNaturalFactors type=":)"/>
    if(openForm === 'antropologicalFactors') form = <CreateAntropologicalFactors/>

    return (
        <div className="add-habitat-container">
             <Typography variant="h3" component="div" gutterBottom style={{padding:"60px"}}>
                Kreiraj novo stanište
            </Typography>
            <Fab style={{backgroundColor:"tan"}} aria-label="add" 
                className="arrow-back" onClick={() => {setOpenForm(formNames[formNames.indexOf(openForm)-1])}}
                disabled={formNames.indexOf(openForm) === 0}> <ArrowBack />
            </Fab>
            <Fab style={{backgroundColor:"tan"}} aria-label="add" 
                className="arrow-next" onClick={() => {setOpenForm(formNames[formNames.indexOf(openForm)+1])}}
                disabled={formNames.indexOf(openForm) === formNames.length-1}
                > <ArrowForward /> 
            </Fab>
            <div className="form-container">
                {form}
            </div>
        </div>
    )

}
export default CreateHabitatPage