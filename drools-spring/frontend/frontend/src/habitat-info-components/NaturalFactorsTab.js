import React, { PureComponent, useState, useEffect } from 'react';
import './style.css'

const NaturalFactorsTab = props => {

    const [naturalFactors, setNaturalFactors] = useState({type: '', exposition: '', elevation: '', mjt: '', slope: '', flooding: ''});
    const [label1, setLabel1] = useState(null);
    const [label2, setLabel2] = useState(null);
    const [labelValue, setLabelValue] = useState(null);

    useEffect(()=> {
        if (props.habitat.id != -1){
            setLabel1(props.habitat.label.label.split(' - ')[0]);
            setLabel2(props.habitat.label.label.split(' - ')[1]);
            setNaturalFactors(props.habitat.naturalFactorsDTO);
            setLabelValue(props.habitat.label.value)
        }
    }, [props])

    let png;
    if (labelValue === 'OPTIMAL') png=require('./OPTIMAL.gif')
    if (labelValue === 'SUBOPTIMAL') png=require('./SUBOPTIMAL.gif')
    if (labelValue === 'MODERATE') png=require('./MODERATE.gif')
    if (labelValue === 'INADEQUATE') png=require('./INADEQUATE.gif')
    if (labelValue===  'INAPPROPRIATE') png=require('./INAPPROPRIATE.gif')

    return (
        <div className="factors-tab-container">
            <div className="natural-factors-container">
                <h1>Prirodni (nepromenljivi) faktori</h1>
                <div className="factor-values-container">
                    <p><b id="factor">Tip staništa: </b>{naturalFactors.type}</p>
                    <p><b id="factor">Ekspozicija: </b> {naturalFactors.exposition}</p>
                    <p><b id="factor">Nadmorska visina: </b> {naturalFactors.elevation}</p>
                    <p><b id="factor">Srednja julska temperatura: </b> {naturalFactors.mjt}</p>
                    <p><b id="factor">Nagib terena: </b> {naturalFactors.slope}</p>
                    <p><b id="factor">Plavljenje: </b> {naturalFactors.flooding}</p>
                    <p><b id="factor">Stanište kreirano: </b> {props.habitat.dateCreated}</p>
                </div>
            </div>
            <div className="label-container">
                <h1>{label1}</h1>
                <p className="label-text">{label2}</p>
                <img src={png} className="gif" alt="loading..." />  
            </div>
        </div>
    )



}
export default NaturalFactorsTab;