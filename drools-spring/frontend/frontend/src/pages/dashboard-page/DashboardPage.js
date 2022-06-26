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

const DashboardPage = () => {

    const navigate = useNavigate();

    const [habitatsList, setHabitatsList] = useState([]);
    const [selectedHabitat, setSelectedHabitat] = useState();

    const [value, setValue] = useState('-1');

    const handleChange = (event, newValue) => {
        setValue(newValue);
      };

    useEffect(() => {
        getHabitats();
    }, [])

    const createNewHabitat = () => {
        localStorage.clear();
        navigate('/create-habitat');
    }

    const getHabitats = () => {
        axios.get(Constants.BasePath + 'user/'+sessionStorage.getItem('username')+'/habitats', 
        { headers: { "Content-Type": "application/json; charset=UTF-8" },
        })
        .then(response => {
            setHabitatsList(response.data)
            setSelectedHabitat(response.data[0]);
        })
        .catch(error => {
            console.log(error.response);
        })
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
                <div className="habitat-list-div">
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
                    <TabContext value={value} >
                        <TabList onChange={handleChange} aria-label="lab API tabs example">
                            <Tab label="Prirodni faktori" value="-1" />
                        </TabList>
                        <TabPanel value="-1"><NaturalFactorsTab habitat={selectedHabitat}/></TabPanel>
                        <TabPanel value="2">Item Two</TabPanel>
                        <TabPanel value="3">Item Three</TabPanel>

                    </TabContext>
                </div>
            </div>
        </div>
    )
}
export default DashboardPage;
