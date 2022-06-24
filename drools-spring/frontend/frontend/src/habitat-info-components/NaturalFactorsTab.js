import React, { PureComponent, useState, useEffect } from 'react';
import './style.css'

const NaturalFactorsTab = () => {

    const [naturalFactors, setNaturalFactors] = useState({type: '', exposition: '', elevation: '', mjt: '', slope: '', flooding: ''});
    const [label, setLabel] = useState(null);

    useEffect(()=> {
        const habitat = localStorage.getItem('selectedHabitat');
        const parsedHabitat = JSON.parse(habitat);
        console.log(parsedHabitat);
        setLabel(parsedHabitat.label);
        setNaturalFactors(parsedHabitat.naturalFactorsDTO);
    }, [])

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
            </div>
            <div className="label-container">
                <h1>{label}</h1>
                <img src={require('./happy.gif')} className="gif" alt="loading..." />
            </div>
        </div>
    )



}
export default NaturalFactorsTab;