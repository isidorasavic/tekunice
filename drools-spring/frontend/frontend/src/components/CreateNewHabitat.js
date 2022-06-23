import React, { PureComponent, useState } from 'react';
import FormControl from '@mui/material/FormControl';
import FormHelperText from '@mui/material/FormHelperText';
import Select from '@mui/material/Select';
import TextField from '@mui/material/TextField'
import MenuItem from '@mui/material/MenuItem';
import InputLabel from '@mui/material/InputLabel';
import './style.css'

const CreateNewHabitat = () => {

    const [name, setName] = useState();
    const [type, setType] = useState();

    //TODO: dobavlja se sa beka ovo
    const typeOptions = [{label:'Panonske zaslanjene stepe', value:'PZS'}, {label:'Suvi peskoviti krecnjacki pasnjaci', value:'PSKP'},
                            {label:'Panonski stepski pasnjaci na lesu', value:'PSPL'}, {label:'Sekundarne livade sa visokom travom koja se kosi', value:'SLVTKSK'}]
 

    return (
        <div>
            <form className="form">
                <div className="form-element"><TextField id="outlined-basic" label="Ime staništa" variant="outlined" value={name} onChange={(event)=>{setName(event.target.value)}} style={{width:"100%"}}/></div>
                <div className="form-element"><FormControl fullWidth>
                    <InputLabel id="demo-simple-select-label">Tip staništa</InputLabel>
                    <Select
                        labelId="demo-simple-select-label"
                        id="demo-simple-select"
                        value={type}
                        label="Tip staništa"
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