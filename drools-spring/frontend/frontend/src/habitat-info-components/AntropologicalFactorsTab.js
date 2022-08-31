import React, { PureComponent, useState, useEffect } from 'react';
import './style.css'
import * as Constants from '../constants'
import axios from 'axios'
import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';
import ListItem from '@mui/material/ListItem';
import ListItemIcon from '@mui/material/ListItemIcon';
import Divider from '@mui/material/Divider';
import InboxIcon from '@mui/icons-material/Inbox';
import AutoFixHighIcon from '@mui/icons-material/AutoFixHigh';

const AntropologicalFactorsTab = props => {

    const [antropologicalFactors, setAntropologicalFactors] = useState({shrubbery:'', distance:'', disturbance:'', roads:'', agriculture:'', grazing:'', grassRemoving:'', predators:'', protection:'', purpose:''});
    const [recommendations, setRecommendations] = useState({recommendations: [], message: '', rate: 0});
    const [habitatLabel, setHabitatLabel] = useState('');

    useEffect(()=> {
        if (props.af.shrubbery.value != null){
            setAntropologicalFactors({shrubbery:props.af.shrubbery, distance:props.af.distanceToNeighbourhoodPopulation, disturbance:props.af.disturbance, roads:props.af.roads, agriculture:props.af.agriculture, grazing:props.af.grazing, grassRemoving:props.af.grassRemoving, predators:props.af.predators, protection:props.af.protection, purpose:props.af.purpose});
            getRecommendation(props.af.id);
            console.log("label: ", props.habitatLabel);
            setHabitatLabel(props.habitatLabel);
        }
    }, [props])

    const getRecommendation = (id) => {
        axios.get(Constants.BasePath + 'anthropologicalFactors/'+ id  + '/recommendations', 
        { headers: { "Content-Type": "application/json; charset=UTF-8" },
        })
        .then(response => {
            console.log("rec: ", response.data);
            setRecommendations({recommendations: response.data.recommendations, message: response.data.successMessage, rate: response.data.successRate})
        })
        .catch(error => {
            console.log(error.response);
        })
    }

    return (
        <div className="factors-tab-container">
            <div className="natural-factors-container">
                <h1>Antropološki (ljudski) faktori</h1>
                <div className="factor-values-container">
                    <p><b id="factor">Obrastanje žbunastim vrstama: </b>{antropologicalFactors.shrubbery.label}</p>
                    <p><b id="factor">Fragmentiranost i udaljenost susednih populacija: </b> {antropologicalFactors.distance.label}</p>
                    <p><b id="factor">Hvatanje, trovanje, krivolov i uznemiravanje životinja: </b> {antropologicalFactors.disturbance.label}</p>
                    <p><b id="factor">Saobraćajnice: </b> {antropologicalFactors.agriculture.label}</p>
                    <p><b id="factor">Poljoprivreda: </b> {antropologicalFactors.agriculture.label}</p>
                    <p><b id="factor">Ispaša: </b> {antropologicalFactors.grazing.label}</p>
                    <p><b id="factor">Uklanjanje travnate površine: </b> {antropologicalFactors.grassRemoving.label}</p>
                    <p><b id="factor">Predatori (price grabljivice, domaće mačke,..): </b> {antropologicalFactors.predators.label}</p>
                    <p><b id="factor">Da li stanište ima neki vid zaštite?: </b> {antropologicalFactors.protection.label}</p>
                    <p><b id="factor">Vlasništvo i namena parcele: </b> {antropologicalFactors.purpose.label}</p>
                </div>
            </div>
            <div className="label-container" >
                <h1>Preporuke</h1>
                {habitatLabel === "INAPPROPRIATE" ? 
                    <p className="inappropriate-label">Stanište je na osnovu svojih prirodnih faktora određeno kao nepovoljno, i nažalost ne postoje ljudske akcije koje bi ga mogle poboljšati. :(</p>  
                    :                    
                    <div className="recommendations-div">
                        {recommendations.recommendations.map((recommendation) => (
                            <div>
                                <ListItem style={{textAlign:"center", height:"70px"}}>
                                    <ListItemIcon>
                                        <AutoFixHighIcon sx={Constants.iconStyle} />
                                    </ListItemIcon>
                                    <ListItemText primary={recommendation.label} />
                                </ListItem>
                                <Divider sx={Constants.iconStyle}/>
                            </div>
                        ))}
                        <p className="succes-label">{recommendations.message} </p> 
                        {recommendations.rate !== 0.9 ? <b className="success-rate">{recommendations.rate * 100}%</b> : null}
                    </div>
                }
            </div>
        </div>

    )

}
export default AntropologicalFactorsTab