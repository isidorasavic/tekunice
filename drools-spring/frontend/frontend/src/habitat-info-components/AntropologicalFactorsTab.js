import React, { PureComponent, useState, useEffect } from 'react';
import './style.css'


const AntropologicalFactorsTab = props => {

    const [antropologicalFactors, setAntropologicalFactors] = useState({shrubbery:'', distance:'', disturbance:'', roads:'', agriculture:'', grazing:'', grassRemoving:'', predators:'', protection:'', purpose:''});

    useEffect(()=> {
        setAntropologicalFactors({shrubbery:props.habitat.antropologicalFactorsDTO.shrubbery, distance:props.habitat.antropologicalFactorsDTO.distanceToNeighbourhoodPopulation, disturbance:props.habitat.antropologicalFactorsDTO.disturbance, roads:props.habitat.antropologicalFactorsDTO.roads, agriculture:props.habitat.antropologicalFactorsDTO.agriculture, grazing:props.habitat.antropologicalFactorsDTO.grazing, grassRemoving:props.habitat.antropologicalFactorsDTO.grassRemoving, predators:props.habitat.antropologicalFactorsDTO.predators, protection:props.habitat.antropologicalFactorsDTO.protection, purpose:props.habitat.antropologicalFactorsDTO.purpose});
        console.log(props.habitat)
    }, [props])


    return (
        <div className="ant-factors-tab-container">
        <div className="natural-factors-container">
            <div id="nf">
                <p><b id="factor">Obrastanje žbunastim vrstama:</b><p id="factor-value">{antropologicalFactors.shrubbery}</p></p>
            </div>
            <div id="nf">
            <p><b id="factor">Fragmentiranost i udaljenost susednih populacija:</b><p id="factor-value">g</p></p>
            </div>
            <div id="nf">
            <p><b id="factor">Hvatanje, trovanje, krivolov i uznemiravanje životinja:</b><p id="factor-value">g</p></p>
            </div>
            <div id="nf">
            <p><b id="factor">Saobraćajnice:</b><p id="factor-value">g</p></p>
            </div>
            <div id="nf">
            <p><b id="factor">Poljoprivreda:</b><p id="factor-value">g</p></p>
            </div>

        </div>
        <div className="natural-factors-container">
            <div id="nf">
            <p><b id="factor">Ispaša:</b><p id="factor-value">g</p></p>
            </div>
            <div id="nf">
            <p><b id="factor">Uklanjanje travnate površine:</b><p id="factor-value">g</p></p>
            </div>
            <div id="nf">
            <p><b id="factor">Predatori (price grabljivice, domaće mačke,..):</b><p id="factor-value">g</p></p>
            </div>
            <div id="nf">
            <p><b id="factor">Da li stanište ima neki vid zaštite?:</b><p id="factor-value">g</p></p>
            </div>
            <div id="nf">
            <p><b id="factor">Vlasništvo i namena parcele:</b><p id="factor-value">g</p></p>
            </div>

        </div>
    </div>

    )

}
export default AntropologicalFactorsTab