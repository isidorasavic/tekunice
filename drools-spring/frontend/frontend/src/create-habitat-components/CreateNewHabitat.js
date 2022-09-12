import React, { PureComponent, useEffect, useState } from 'react';
import FormControl from '@mui/material/FormControl';
import FormHelperText from '@mui/material/FormHelperText';
import Select from '@mui/material/Select';
import TextField from '@mui/material/TextField'
import MenuItem from '@mui/material/MenuItem';
import InputLabel from '@mui/material/InputLabel';
import './style.css'
import axios from 'axios'
import * as Constants from '../constants'


const CreateNewHabitat = () => {
    const [name, setName] = useState(localStorage.getItem('name'));
    const [type, setType] = useState(localStorage.getItem('type'));
    const [typeOptions, setTypeOptions] = useState([]);

    useEffect(()=> {
        setType(localStorage.getItem('type'))
        axios
          .get(Constants.BasePath + 'typeOptions', 
          { headers: { "Content-Type": "application/json; charset=UTF-8" },
          })
          .then(response => {
            setTypeOptions(response.data);
          })
          .catch(error => {
              console.log(error.response);
            })
    }, [])    
    
    const changeType = (event) => {
        setType(event.target.value);
        localStorage.setItem('type', event.target.value)
        console.log(localStorage.getItem('type'))
    }

    return (
        <div>
            <form className="form">
                <div className="form-element"><TextField id="outlined-basic" label="Ime staništa" variant="outlined" value={name} onChange={(event)=>{
                    setName(event.target.value);
                    localStorage.setItem('name', event.target.value)    
                }} style={{width:"100%"}}/></div>
                <div className="form-element"><FormControl fullWidth>
                    <InputLabel id="demo-simple-select-label">Tip staništa</InputLabel>
                    <Select
                        labelId="demo-simple-select-label"
                        id="demo-simple-select"
                        value={type}
                        label="Tip staništa"
                        onChange={changeType}
                    >
                        {typeOptions.map((option) => (
                            <MenuItem key={option.value} value={option.value}>
                            {option.label}
                            </MenuItem>
                        ))}
                    </Select>
                </FormControl></div>
            </form>
        </div>
    )
}

export default CreateNewHabitat