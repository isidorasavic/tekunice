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
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from "react-router-dom"
import HabitatCreatedModal from './HabitatCreatedModal';

const CreateAntropologicalFactors = () => {

    const { enqueueSnackbar } = useSnackbar();
    const navigate = useNavigate();

    const [modalData, setModalData] = useState({open: false, title: '', subtitle:''})

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
        if (localStorage.getItem('shrubbery') === null || localStorage.getItem('distance') === null ||
            localStorage.getItem('disturbance') === null || localStorage.getItem('roads') === null ||
            localStorage.getItem('agriculture') === null || localStorage.getItem('grazing') === null ||
            localStorage.getItem('grassRemoving') === null || localStorage.getItem('predators') === null ||
            localStorage.getItem('protection') === null || localStorage.getItem('purpose') === null){
            enqueueSnackbar('Obavezno je uneti sve ljudske faktore!', {variant: 'error'});
            return false;
        }
        return true;
    }

    const handleCloseModal= () => {
        setModalData({open: false, title: '', subtitle:''});
        navigate('/dashboard')
    }

    const submitHabitat = (event) => {
        event.preventDefault();
        if (checkCreateHabitatFormsValid()) {
            const habitat = {
                name: localStorage.getItem("name"),
                username: sessionStorage.getItem("username"),
                naturalFactorsDTO: {
                    type: localStorage.getItem("type"),
                    exposition: localStorage.getItem("exposition"),
                    elevation: localStorage.getItem("elevation"),
                    mjt: localStorage.getItem("mjt"),
                    slope: localStorage.getItem("slope"),
                    flooding: localStorage.getItem("flooding")
                },
                antropologicalFactorDTO: {
                    shrubbery: {
                        value: localStorage.getItem('shrubbery'),
                        type: 'shrubbery'

                    },
                    distanceToNeighbourhoodPopulation: {
                        value: localStorage.getItem('distance'),
                        type: 'distanceToNeighbourhoodPopulation'

                    },
                    disturbance: {
                        value: localStorage.getItem('disturbance'),
                        type: 'disturbance'

                    },
                    roads: {
                        value: localStorage.getItem('roads'),
                        type: 'roads'

                    },
                    agriculture: {
                        value: localStorage.getItem('agriculture'),
                        type: 'agriculture'

                    },
                    grazing: {
                        value: localStorage.getItem('grazing'),
                        type: 'grazing'

                    },
                    grassRemoving: {
                        value: localStorage.getItem('grassRemoving'),
                        type: 'grassRemoving'

                    },
                    predators: {
                        value: localStorage.getItem('predators'),
                        type: 'predators'

                    },
                    protection: {
                        value: localStorage.getItem('protection'),
                        type: 'protection'

                    },
                    purpose: {
                        value: localStorage.getItem('purpose'),
                        type: 'purpose'

                    }
                }
            }
            console.log(habitat);
            axios.post(Constants.BasePath + 'addHabitat', habitat, 
            { headers: { "Content-Type": "application/json; charset=UTF-8" },
            })
            .then(response => {
                console.log('response:', response.data);
                setModalData({...modalData, open:true, title: response.data.label.split(' - ')[0], subtitle: response.data.label.split(' - ')[0]})
                

            })
            .catch(error => {
                console.log(error.response);
            })
            }
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
            <HabitatCreatedModal open={modalData.open} title={modalData.title} subtitle={modalData.subtitle} closeModal={handleCloseModal}/>
        </div>
    )



}
export default CreateAntropologicalFactors