import React, { PureComponent, useEffect, useState } from 'react';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import './style.css'

const CreateNaturalFactors = props => {

    const [naturalFactors, setNaturalFactors] = useState({exposition: null, elevation: null, mjt: null, slope: null, flooding: null});

    const [allOptions, setAllOptions] = useState({habitatType: null, elevationOptions:[], mjtOptions: [], expositionOptions:[], floodingOptions:[], slopeOptions:[]});

    useEffect(() => {
        //TODO:
        //metoda koja sa beka dobavlja sve opcije
        console.log('type:', props.type)
        setAllOptions({...allOptions, habitatType: props.type});
    }, [props.type]);

    return (
        <div>
            <form className="form">
                <div className="form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Ekspozicija staništa</InputLabel>
                        <Select
                            style={{accentColor:"tan"}}
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={naturalFactors.exposition}
                            label="Ekspozicija stanista"
                        >
                            {allOptions.expositionOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
                <div className="form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Nadmorska visina</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={naturalFactors.elevation}
                            label="Nadmorska visina"
                        >
                            {allOptions.elevationOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
                <div className="form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Srednja julska temperatura</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={naturalFactors.mjt}
                            label="Srednja julska temperatura"
                        >
                            {allOptions.mjtOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
                <div className="form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Nagib terena</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={naturalFactors.slope}
                            label="Nagib stanista"
                        >
                            {allOptions.slopeOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
                <div className="form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Nivo podzemnih voda i povremeno plavljenje</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={naturalFactors.exposition}
                            label="Ekspozicija stanista"
                        >
                            {allOptions.floodingOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
            </form>
        </div>
    )

}
export default CreateNaturalFactors