import React, { PureComponent, useState, useEffect } from 'react';
import './style.css'
import * as Constants from '../../constants'
import axios from 'axios'
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from "react-router-dom"
import Button from '@mui/material/Button'
import List from '@mui/material/List';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import LocalFloristOutlinedIcon from '@mui/icons-material/LocalFloristOutlined';
import HeaderComponent from '../../components/header-component/HeaderComponent';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import PropTypes from 'prop-types';
import NaturalFactorsTab from '../../habitat-info-components/NaturalFactorsTab';
import AntropologicalFactorsTab from '../../habitat-info-components/AntropologicalFactorsTab';
import ArrowForward from '@mui/icons-material/ArrowForward';
import ArrowBack from '@mui/icons-material/ArrowBack';
import AddIcon from '@mui/icons-material/Add';
import Tooltip from '@mui/material/Tooltip';

function TabPanel(props) {
    const { children, value, index, ...other } = props;
  
    return (
      <div
        role="tabpanel"
        hidden={value !== index}
        id={`simple-tabpanel-${index}`}
        aria-labelledby={`simple-tab-${index}`}
        {...other}
      >
        {value === index && (
          <Box sx={{ p: 3 }}>
            <Typography>{children}</Typography>
          </Box>
        )}
      </div>
    );
  }
  
  TabPanel.propTypes = {
    children: PropTypes.node,
    index: PropTypes.number.isRequired,
    value: PropTypes.number.isRequired,
  };

function a11yProps(index) {
    return {
      id: `simple-tab-${index}`,
      'aria-controls': `simple-tabpanel-${index}`,
    };
}

const DashboardPage = () => {

    const navigate = useNavigate();

    const [habitatsList, setHabitatsList] = useState([]);
    const [selectedHabitat, setSelectedHabitat] = useState({id: -1, userId:-1, label: '', name:'', naturalFactorsDTO: null, antropologicalFactorDTO: null});
    const [selectedAntropologicalFactors, setSelectedAntropologicalFactors] = useState([]);

    const [value, setValue] = useState(0);
    useEffect(() => {
        axios.get(Constants.BasePath + 'user/'+sessionStorage.getItem('username')+'/habitats', 
        { headers: { "Content-Type": "application/json; charset=UTF-8" },
        })
        .then(response => {
            setHabitatsList(response.data)
            selectHabitat(response.data[0].id);
        })
        .catch(error => {
            console.log(error.response);
        })
    }, [])

    const createNewHabitat = () => {
        localStorage.clear();
        navigate('/create-habitat');
    }

    const selectHabitat = (id) => {
        axios.get(Constants.BasePath + 'habitat/' + id, 
        { headers: { "Content-Type": "application/json; charset=UTF-8" },
        })
        .then(response => {
            setSelectedHabitat(response.data);
            setSelectedAntropologicalFactors(response.data.anthropologicalFactorDTO);
        })
        .catch(error => {
            console.error(error);
        })
    }

    if (sessionStorage.getItem('username') === null) {
        return (
            <div>
                <h1>Unauthorized</h1>
            </div>
        )
    }

 
    const addNewAnthropologicalFactors = (habitatId) => {
        localStorage.clear();
        navigate('/new-anthropological-factors/'+habitatId);
    }

    const handleChange = (event, newValue) => {
        setValue(newValue);
      };

    return (
        <div className="dashboard-container">
            <HeaderComponent/>
            {/* lista postojecih stanista */}
            <div className="content-div">
                <div className={habitatsList.length > 10 ? "habitat-list-div-scrollable" : "habitat-list-div"}>
                    <Button variant="outlined" sx={Constants.bttnStyle} onClick={createNewHabitat}>Dodaj novo stanište</Button>
                    <List component="nav" sx={{marginTop:"20px"}} aria-label="main mailbox folders">
                    {habitatsList.map((habitat, index) => (
                        <div style={{display: "flex", flexDisplay:"row"}}>
                            <ListItemButton
                                selected={selectedHabitat.name === habitat.name}
                                onClick={(event) => selectHabitat(habitat.id)}
                                >
                                <ListItemIcon>
                                    <LocalFloristOutlinedIcon sx={Constants.iconStyle} />
                                </ListItemIcon>
                                <ListItemText primary={habitat.name}/>
                                
                            </ListItemButton>
                        </div>
                    ))}
                    </List>
                </div>
                {/* trenutno prikazano staniste */}
                <div className="selected-habitat-div">
                    <Box sx={{ borderBottom: 2, borderColor: 'divider' }}>
                        <Tabs value={value} onChange={handleChange} aria-label="basic tabs example">
                        <Tab style={Constants.tabBttnStyle} label="Prirodni faktori" {...a11yProps(0)} />
                        {selectedAntropologicalFactors.map((af, index) => (
                            <Tab style={Constants.tabBttnStyle} label={"Antropološki faktori: "+af.dateAdded} {...a11yProps(index+1)} />
                        ))}
                        {selectedHabitat.label.value === "INAPPROPRIATE" ? null : <Tooltip title="Dodaj nove antropološke faktore">
                            <Button {...a11yProps(100)} style={Constants.newAFBttnStyle} onClick={(event) => addNewAnthropologicalFactors(selectedHabitat.id)}><AddIcon/></Button>
                        </Tooltip>}

                        </Tabs>
                    </Box>
                    <TabPanel style={{height: '70vh'}} value={value} index={0}>
                        <NaturalFactorsTab habitat={selectedHabitat}></NaturalFactorsTab>
                    </TabPanel>
                    {selectedAntropologicalFactors.map((af, index) => (
                        <TabPanel style={{height: '70vh'}} value={value} index={index+1}>
                            <AntropologicalFactorsTab af={af} habitatLabel={selectedHabitat.label.value}></AntropologicalFactorsTab>
                        </TabPanel>
                    ))}
                    </div>
            </div>
        </div>
    )
}
export default DashboardPage;
