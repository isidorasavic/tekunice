import React, { PureComponent, useState, useEffect } from 'react';
import Typography from '@mui/material/Typography';
import Fab from '@mui/material/Fab';
import './style.css'
import * as Constants from '../../constants'
import axios from 'axios'
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from "react-router-dom"
import TextField from '@mui/material/TextField'
import InputAdornment from '@mui/material/InputAdornment';
import IconButton from '@mui/material/IconButton';
import FormControl from '@mui/material/FormControl';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import OutlinedInput from '@mui/material/OutlinedInput';
import Button from '@mui/material/Button'
import Box from '@mui/material/Box';
import List from '@mui/material/List';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Divider from '@mui/material/Divider';
import InboxIcon from '@mui/icons-material/Inbox';
import DraftsIcon from '@mui/icons-material/Drafts';
import LocalFloristOutlinedIcon from '@mui/icons-material/LocalFloristOutlined';
import NaturalFactorsTab from '../../habitat-info-components/NaturalFactorsTab'
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import TabList from '@mui/lab/TabList';
import TabPanel from '@mui/lab/TabPanel';
import TabContext from '@mui/lab/TabContext';
import AntropologicalFactorsTab from '../../habitat-info-components/AntropologicalFactorsTab';

const DashboardPage = () => {

    const navigate = useNavigate();

    const [habitatsList, setHabitatsList] = useState([]);
    const [selectedHabitat, setSelectedHabitat] = useState({userId:-1, label: null, name:'', naturalFactorsDTO: null, antropologicalFactorDTO: null});
    const [selectedNaturalFactors, setSelectedNaturalFactors] = useState({type: '', exposition: '', elevation: '', mjt: '', slope: '', flooding: ''})
    const [selectedAntropoloicalFactors, setSelectedAntropologicalFactors] = useState({shrubbery:'', distanceToNeighbourhoodPopulation:'', disturbance:'', roads:'', agriculture:'', grazing:'', grassRemoving:'', predators:'', protection:'', purpose:''})

    const [label1, setLabel1] = useState('');
    const [label2, setLabel2] = useState('');
    const [labelValue, setLabelValue] = useState('');

    let png;
    if (labelValue === 'OPTIMAL') png=require('./OPTIMAL.gif')
    if (labelValue === 'SUBOPTIMAL') png=require('./SUBOPTIMAL.gif')
    if (labelValue === 'MODERATE') png=require('./MODERATE.gif')
    if (labelValue === 'INADEQUATE') png=require('./INADEQUATE.gif')
    if (labelValue ===  'INAPPROPRIATE') png=require('./INAPPROPRIATE.gif')

    useEffect(() => {
        axios.get(Constants.BasePath + 'user/'+sessionStorage.getItem('username')+'/habitats', 
        { headers: { "Content-Type": "application/json; charset=UTF-8" },
        })
        .then(response => {
            setHabitatsList(response.data)
            setSelectedHabitat(response.data[0]);
            setLabel1(response.data[0].label.label.split(' - ')[0]);
            setLabel2(response.data[0].label.label.split(' - ')[1]);
            setLabelValue(response.data[0].label.value)
            setSelectedNaturalFactors(response.data[0].naturalFactorsDTO)
            setSelectedAntropologicalFactors(response.data[0].antropologicalFactorDTO)

            console.log("selected habitat: ",response.data[0])
        })
        .catch(error => {
            console.log(error.response);
        })
    }, [])

    const createNewHabitat = () => {
        localStorage.clear();
        navigate('/create-habitat');
    }

    const logOut = () => {
        localStorage.clear();
        sessionStorage.clear();
        axios.post(Constants.BasePath + 'auth/logout', 
        { headers: { "Content-Type": "application/json; charset=UTF-8" },
        })
        .then(response => {
            console.log(response.data);
            navigate('/login');
        })
        .catch(error => {
            console.log(error.response);
          })
    }

    if (sessionStorage.getItem('username') === null) {
        return (
            <div>
                <h1>Unauthorized</h1>
            </div>
        )
    }
    const handleListItemClick = (event, index) => {
        setSelectedHabitat(habitatsList.at(index));
        setLabel1(habitatsList.at(index).label.label.split(' - ')[0]);
        setLabel2(habitatsList.at(index).label.label.split(' - ')[1]);
        setLabelValue(habitatsList.at(index).label.value)
        setSelectedNaturalFactors(habitatsList.at(index).naturalFactorsDTO)
        setSelectedAntropologicalFactors(habitatsList.at(index).antropologicalFactorDTO)


      };

    return (
        <div className="dashboard-container">
            <div className="header-div">
                <div className="logo">
                    <img src="icon.png" className="logo-image" alt="tekunica"/>
                    <div>Srećne tekunice</div>
                </div>
                <div className="dashboard-title">
                    Moja staništa
                </div>
                <div className="log-out-div">
                    <Button variant="outlined" sx={Constants.bttnStyle} onClick={logOut} className="log_out-bttn">Log out</Button>
                </div>
            </div>
            <div className="content-div">
                <div className={habitatsList.length > 10 ? "habitat-list-div-scrollable" : "habitat-list-div"}>
                    <Button variant="outlined" sx={Constants.bttnStyle} onClick={createNewHabitat}>Dodaj novo stanište</Button>
                    <List component="nav" sx={{marginTop:"20px"}} aria-label="main mailbox folders">
                    {habitatsList.map((habitat, index) => (
                        <ListItemButton
                            selected={selectedHabitat.name === habitat.name}
                            onClick={(event) => handleListItemClick(event, index)}
                            >
                            <ListItemIcon>
                                <LocalFloristOutlinedIcon sx={Constants.iconStyle} />
                            </ListItemIcon>
                            <ListItemText primary={habitat.name}/>
                        </ListItemButton>
                    ))}
                    </List>
                </div>
                <div className="selected-habitat-div">
                    <div className="natural-factors-container">
                        <div id="nf">
                                <p><b id="factor">Tip staništa:</b><p id="factor-value">{selectedNaturalFactors.type}</p></p>
                            </div>
                            <div id="nf">
                                <p><b id="factor">Ekspozicija:</b><p id="factor-value">{selectedNaturalFactors.exposition}</p></p>
                            </div>
                            <div id="nf">
                                <p><b id="factor">Nadmorska visina:</b><p id="factor-value">{selectedNaturalFactors.elevation}</p></p>
                            </div>
                            <div id="nf">
                                <p><b id="factor">Srednja julska temperatura:</b><p id="factor-value">{selectedNaturalFactors.mjt}</p></p>
                            </div>
                            <div id="nf">
                                <p><b id="factor">Nagib terena:</b><p id="factor-value">{selectedNaturalFactors.slope}</p></p>
                            </div>
                            <div id="nf">
                                <p><b id="factor">Plavljenje:</b><p id="factor-value">{selectedNaturalFactors.flooding}</p></p>
                            </div>
                            <div id="nf">
                            <p><b id="factor">Stanište kreirano:</b><p id="factor-value">{selectedHabitat.dateCreated}</p></p>
                            </div>
                        </div>
                        <div className="natural-factors-container">
                        <div id="nf">
                                <p><b id="factor">Procenat prisutnosti žbunastih vrsta:</b><p id="factor-value">{selectedAntropoloicalFactors.shrubbery.label}</p></p>
                            </div>
                            <div id="nf">
                                <p><b id="factor">Udaljenost susednih populacija:</b><p id="factor-value">{selectedAntropoloicalFactors.distanceToNeighbourhoodPopulation.label}</p></p>
                            </div>
                            <div id="nf">
                                <p><b id="factor">Hvatanje, trovanje i uznemiravanje životinja:</b><p id="factor-value">{selectedAntropoloicalFactors.disturbance.label}</p></p>
                            </div>
                            <div id="nf">
                                <p><b id="factor">Saobraćajnice:</b><p id="factor-value">{selectedAntropoloicalFactors.roads.label}</p></p>
                            </div>
                            <div id="nf">
                                <p><b id="factor">Poljoprivreda:</b><p id="factor-value">{selectedAntropoloicalFactors.agriculture.label}</p></p>
                            </div>
                            <div id="nf">
                                <p><b id="factor">Ispaša:</b><p id="factor-value">{selectedAntropoloicalFactors.grazing.label}</p></p>
                            </div>
                            <div id="nf">
                            <p><b id="factor">Uklanjanje travnate površine:</b><p id="factor-value">{selectedAntropoloicalFactors.grassRemoving.label}</p></p>
                            </div>
                            <div id="nf">
                                <p><b id="factor">Predatori:</b><p id="factor-value">{selectedAntropoloicalFactors.predators.label}</p></p>
                            </div>
                            <div id="nf">
                                <p><b id="factor">Da li stanište ima neki vid zaštite?</b><p id="factor-value">{selectedAntropoloicalFactors.protection.label}</p></p>
                            </div>
                            <div id="nf">
                                <p><b id="factor">Vlasništvo i namena parcele:</b><p id="factor-value">{selectedAntropoloicalFactors.purpose.label}</p></p>
                            </div>
                        </div>
                    
                    <div className="label-container">
                        <h1>{label1}</h1>
                        <h4>{label2}</h4>
                        <img src={png} className="gif" alt="loading..." />  
                    </div>
                    </div>
            </div>
        </div>
    )
}
export default DashboardPage;
