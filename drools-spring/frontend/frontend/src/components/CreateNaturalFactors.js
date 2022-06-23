import React, { PureComponent, useEffect, useState } from 'react';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import './style.css'
import * as Constants from '../constants'
import axios from 'axios'


const CreateNaturalFactors = () => {

    const [naturalFactors, setNaturalFactors] = useState({habitatType: localStorage.getItem('type'), exposition: localStorage.getItem('exposition'), elevation: localStorage.getItem('elevation'), mjt: localStorage.getItem('mjt'), slope: localStorage.getItem('slope'), flooding: localStorage.getItem('flooding')});
    const [elevationOptions, setElevationOptions] = useState([]);
    const [expositionOptions, setExpositionOptions] = useState([]);
    const [mjtOptions, setMjtOptions] = useState([]);
    const [floodingOptions, setFloodingOptions] = useState([]);
    const [slopeOptions, setSlopeOptions] = useState([]);


    useEffect(() => {
        axios
        .get(Constants.BasePath + 'naturalFactorOptions?type='+localStorage.getItem('type'), 
        { headers: { "Content-Type": "application/json; charset=UTF-8" },
        })
        .then(response => {
            console.log(response.data);
            setElevationOptions(response.data.elevationOptions);
            setExpositionOptions(response.data.expositionOptions);
            setMjtOptions(response.data.mjtOptions);
            setFloodingOptions(response.data.floodingOptions);
            setSlopeOptions(response.data.slopeOptions);
        })
        .catch(error => {
            console.log(error.response);
          })
    }, []);

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
                            onChange={(event)=>{
                                setNaturalFactors({...naturalFactors, exposition: event.target.value});
                                localStorage.setItem('exposition', event.target.value);
                            }}
                        >
                            {expositionOptions.map((option) => (
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
                            onChange={(event)=>{
                                setNaturalFactors({...naturalFactors, elevation: event.target.value});
                                localStorage.setItem('elevation', event.target.value);
                            }}
                        >
                            {elevationOptions.map((option) => (
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
                            onChange={(event)=>{
                                setNaturalFactors({...naturalFactors, mjt: event.target.value});
                                localStorage.setItem('mjt', event.target.value);
                            }}
                        >
                            {mjtOptions.map((option) => (
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
                            onChange={(event)=>{
                                setNaturalFactors({...naturalFactors, slope: event.target.value});
                                localStorage.setItem('slope', event.target.value);
                            }}
                        >
                            {slopeOptions.map((option) => (
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
                            value={naturalFactors.flooding}
                            label="Nivo podzemnih voda i povremeno plavljenje"
                            onChange={(event)=>{
                                setNaturalFactors({...naturalFactors, flooding: event.target.value});
                                localStorage.setItem('flooding', event.target.value);
                            }}
                        >
                            {floodingOptions.map((option) => (
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