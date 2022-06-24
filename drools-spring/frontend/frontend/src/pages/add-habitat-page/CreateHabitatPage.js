import React, { PureComponent, useState } from 'react';
import './style.css'
import CreateNewHabitat from '../../create-habitat-components/CreateNewHabitat'
import CreateNaturalFactors from '../../create-habitat-components/CreateNaturalFactors'
import Typography from '@mui/material/Typography';
import Fab from '@mui/material/Fab';
import ArrowForward from '@mui/icons-material/ArrowForward';
import ArrowBack from '@mui/icons-material/ArrowBack';
import CreateAntropologicalFactors from '../../create-habitat-components/CreateAntropologicalFactors'

const CreateHabitatPage = () => {

    const [openForm, setOpenForm] = useState('createNew');

    const formNames = ["createNew", "naturalFactors", "antropologicalFactors"]

    let form;
    if(openForm === 'createNew') form = <CreateNewHabitat/>
    if(openForm === 'naturalFactors') form = <CreateNaturalFactors/>
    if(openForm === 'antropologicalFactors') form = <CreateAntropologicalFactors/>

    if (sessionStorage.getItem('username') === null) {
        return (
            <div>
                <h1>Unauthorized</h1>
            </div>
        )
    }

    return (
        <div className="add-habitat-container">
             <Typography variant="h3" component="div" gutterBottom style={{padding:"60px"}}>
                Kreiraj novo stanište
            </Typography>
            <div className="form-container">
                <div className="round-bttn-container">
                    <div className="round-bttn" style={{textAlign:"left"}}>
                        <Fab style={{backgroundColor:"tan"}} aria-label="add" 
                            className="arrow-back" onClick={() => {setOpenForm(formNames[formNames.indexOf(openForm)-1])}}
                            disabled={formNames.indexOf(openForm) === 0}> <ArrowBack />
                        </Fab>
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