import React, { PureComponent, useState, useEffect } from 'react';
import './style.css'

const NaturalFactorsTab = props => {

    const [naturalFactors, setNaturalFactors] = useState({type: '', exposition: '', elevation: '', mjt: '', slope: '', flooding: ''});
    const [label1, setLabel1] = useState(null);
    const [label2, setLabel2] = useState(null);
    const [labelValue, setLabelValue] = useState(null);

    useEffect(()=> {
        setLabel1(props.habitat.label.label.split(' - ')[0]);
        setLabel2(props.habitat.label.label.split(' - ')[1]);
        setNaturalFactors(props.habitat.naturalFactorsDTO);
        setLabelValue(props.habitat.label.value)
        console.log(props.habitat)
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
                <div id="nf">
                    <p><b id="factor">Tip staništa:</b><p id="factor-value">{naturalFactors.type}</p></p>
                </div>
                <div id="nf">
                    <p><b id="factor">Ekspozicija:</b><p id="factor-value">{naturalFactors.exposition}</p></p>
                </div>
                <div id="nf">
                    <p><b id="factor">Nadmorska visina:</b><p id="factor-value">{naturalFactors.elevation}</p></p>
                </div>
                <div id="nf">
                    <p><b id="factor">Srednja julska temperatura:</b><p id="factor-value">{naturalFactors.mjt}</p></p>
                </div>
                <div id="nf">
                    <p><b id="factor">Nagib terena:</b><p id="factor-value">{naturalFactors.slope}</p></p>
                </div>
                <div id="nf">
                    <p><b id="factor">Plavljenje:</b><p id="factor-value">{naturalFactors.flooding}</p></p>
                </div>
                <div id="nf">
                <p><b id="factor">Stanište kreirano:</b><p id="factor-value">{props.habitat.dateCreated}</p></p>
                </div>
            </div>
            <div className="label-container">
                <h1>{label1}</h1>
                <h4>{label2}</h4>
                <img src={png} className="gif" alt="loading..." />  
            </div>
        </div>
    )



}
export default NaturalFactorsTab;