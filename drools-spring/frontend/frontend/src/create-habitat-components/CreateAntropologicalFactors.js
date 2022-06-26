import React, { PureComponent, useState, useEffect } from 'react';
import './style.css'
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import Select from '@mui/material/Select';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import * as Constants from '../constants'
import axios from 'axios'
import Button from '@mui/material/Button'
import { SnackbarProvider, useSnackbar } from 'notistack';


const CreateAntropologicalFactors = () => {

    const { enqueueSnackbar } = useSnackbar();


    const [shrubberyOptions, setShrubberyOptions] = useState([]);
    const [distanceOptions, setDistanceOptions] = useState([]);
    const [disturbanceOptions, setDisturbanceOptions] = useState([]);
    const [roadsOptions, setRoadsOptions] = useState([]);
    const [agricultureOptions, setAgricultureOptions] = useState([]);
    const [grazingOptions, setGrazingOptions] = useState([]);
    const [grassRemovingOptions, setGrassRemovingOptions] = useState([]);
    const [predatorsOptions, setPredatorsOptions] = useState([]);
    const [protectionOptions, setProtectionOptions] = useState([]);
    const [purposeOptions, setPurposeOptions] = useState([]);

    const [antrpologicalFactors, setAntropologicalFactors] = useState({shrubbery:localStorage.getItem('shrubbery'), distance:localStorage.getItem('distance'), disturbance:localStorage.getItem('disturbance'), roads:localStorage.getItem('roads'), agriculture:localStorage.getItem('agriculture'), grazing:localStorage.getItem('grazing'), 
                                        grassRemoving:localStorage.getItem('grassRemoving'), predators:localStorage.getItem('predators'), protection:localStorage.getItem('protection'), purpose:localStorage.getItem('purpose')});


    useEffect(() => {
        axios
        .get(Constants.BasePath + 'antropologicalFactorsOptions', 
        { headers: { "Content-Type": "application/json; charset=UTF-8" },
        })
        .then(response => {
            console.log(response.data);
            setShrubberyOptions(response.data.shrubberyOptions);
            setDistanceOptions(response.data.distanceToNeighbourhoodPopulationOptions);
            setDisturbanceOptions(response.data.disturbanceOptions);
            setRoadsOptions(response.data.roadsOptions);
            setAgricultureOptions(response.data.agricultureOptions);
            setGrazingOptions(response.data.grazingOptions);
            setGrassRemovingOptions(response.data.grassRemovingOptions);
            setPredatorsOptions(response.data.predatorsOptions);
            setProtectionOptions(response.data.protectionOptions);
            setPurposeOptions(response.data.purposeOptions);

        })
        .catch(error => {
            console.log(error.response);
          })
    }, []);

    const checkCreateHabitatFormsValid = () => {
        if (localStorage.getItem('name') === null){
            enqueueSnackbar('Ime staništa ne može biti prazno!', {variant: 'error'});
            return false;
        }
        if (localStorage.getItem('type') === null){
            enqueueSnackbar('Tip staništa ne može biti prazan!', {variant: 'error'});
            return false;
        }
        if (localStorage.getItem('exposition') === null){
            enqueueSnackbar('Ekspozicija staništa ne može biti prazna!', {variant: 'error'});
            return false;
        }
        if (localStorage.getItem('elevation') === null){
            enqueueSnackbar('Nadmorska visina staništa ne može biti prazna!', {variant: 'error'});
            return false;
        }
        if (localStorage.getItem('mjt') === null){
            enqueueSnackbar('Srednja julska temperatura staništa ne može biti prazna!', {variant: 'error'});
            return false;
        }
        if (localStorage.getItem('slope') === null){
            enqueueSnackbar('Nagib staništa ne može biti prazan!', {variant: 'error'});
            return false;
        }
        if (localStorage.getItem('flooding') === null){
            enqueueSnackbar('Plavljenje staništa ne može biti prazno!', {variant: 'error'});
            return false;
        }
        return true;
    }

    const submitHabitat = () => {
        checkCreateHabitatFormsValid();
    }

    return (
        <div>
            <form className="antrpological-form">
                <div className="antropological-form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Procenat prisutnosti žbunastih vrsta</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={antrpologicalFactors.shrubbery}
                            label="Procenat prisutnosti zbunastih vrsta"
                            onChange={(event)=>{
                                setAntropologicalFactors({...antrpologicalFactors, shrubbery: event.target.value});
                                localStorage.setItem('shrubbery', event.target.value);
                            }}
                        >
                            {shrubberyOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
                <div className="antropological-form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Fragmentiranost i udaljenost susednih populacija</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={antrpologicalFactors.distance}
                            label="Fragmentiranost i udaljenost susednih populacija"
                            onChange={(event)=>{
                                setAntropologicalFactors({...antrpologicalFactors, distance: event.target.value});
                                localStorage.setItem('distance', event.target.value);
                            }}
                        >
                            {distanceOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
                <div className="antropological-form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Hvatanje, trovanje, krivolov i uznemiravanje životinja</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={antrpologicalFactors.disturbance}
                            label="Hvatanje, trovanje, krivolog i uznemiravanje zivotinja"
                            onChange={(event)=>{
                                setAntropologicalFactors({...antrpologicalFactors, disturbance: event.target.value});
                                localStorage.setItem('disturbance', event.target.value);
                            }}
                        >
                            {disturbanceOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
                <div className="antropological-form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Saobraćajnice</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={antrpologicalFactors.roads}
                            label="Saobracajnice"
                            onChange={(event)=>{
                                setAntropologicalFactors({...antrpologicalFactors, roads: event.target.value});
                                localStorage.setItem('roads', event.target.value);
                            }}
                        >
                            {roadsOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
                <div className="antropological-form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Poljoprivreda</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={antrpologicalFactors.agriculture}
                            label="Poljoprivreda"
                            onChange={(event)=>{
                                setAntropologicalFactors({...antrpologicalFactors, agriculture: event.target.value});
                                localStorage.setItem('agriculture', event.target.value);
                            }}
                        >
                            {agricultureOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
                <div className="antropological-form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Ispaša</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={antrpologicalFactors.grazing}
                            label="Ispasa"
                            onChange={(event)=>{
                                setAntropologicalFactors({...antrpologicalFactors, grazing: event.target.value});
                                localStorage.setItem('grazing', event.target.value);
                            }}
                        >
                            {grazingOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
                <div className="antropological-form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Uklanjanje travnate površine</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={antrpologicalFactors.grassRemoving}
                            label="Uklanjanje travnate povrsine"
                            onChange={(event)=>{
                                setAntropologicalFactors({...antrpologicalFactors, grassRemoving: event.target.value});
                                localStorage.setItem('grassRemoving', event.target.value);
                            }}
                        >
                            {grassRemovingOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
                <div className="antropological-form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Predatori (price grabljivice, domaće mačke,..)</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={antrpologicalFactors.predators}
                            label="Predatori (price grabljivice, domace macke,..)"
                            onChange={(event)=>{
                                setAntropologicalFactors({...antrpologicalFactors, predators: event.target.value});
                                localStorage.setItem('predators', event.target.value);
                            }}
                        >
                            {predatorsOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
                <div className="antropological-form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Da li stanište ima neki vid zaštite?</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={antrpologicalFactors.protection}
                            label="Da li staniste ima neki vid zastite?"
                            onChange={(event)=>{
                                setAntropologicalFactors({...antrpologicalFactors, protection: event.target.value});
                                localStorage.setItem('protection', event.target.value);
                            }}
                        >
                            {protectionOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
                <div className="antropological-form-element">
                    <FormControl fullWidth>
                        <InputLabel id="demo-simple-select-label">Vlasništvo i namena parcele</InputLabel>
                        <Select
                            labelId="demo-simple-select-label"
                            id="demo-simple-select"
                            value={antrpologicalFactors.purpose}
                            label="Vlasnistvo i namena parcele"
                            onChange={(event)=>{
                                setAntropologicalFactors({...antrpologicalFactors, purpose: event.target.value});
                                localStorage.setItem('purpose', event.target.value);
                            }}
                        >
                            {purposeOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
            </form>
            <Button className='submit-bttn' variant="outlined" onClick={submitHabitat} style={{marginTop:"30px"}} sx={Constants.bttnStyle}>Kreiraj novo stanište</Button>
        </div>
    )



}
export default CreateAntropologicalFactors