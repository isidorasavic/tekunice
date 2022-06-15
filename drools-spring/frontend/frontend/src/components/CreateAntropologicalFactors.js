import React, { PureComponent, useState } from 'react';
import './style.css'
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import Select from '@mui/material/Select';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';


const CreateAntropologicalFactors = () => {

    const [allOptions, setAllOptions] = useState({shrubberyOptions:[], distanceOptions:[], disturbanceOptions:[], roadsOptions:[], agricultureOptions:[], grazingOptions:[], grassRemovingOptions:[], predatorsOptions:[], protectionOptions: [], purposeOptions:[]});

    const [antrpologicalFactors, setAntropologicalFactors] = useState({shrubbery:null, distance:null, disturbance:null, roads:null, agriculture:null, grazing:null, grassRemoving:null, predators:null, protection:null, purpose:null});

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
                        >
                            {allOptions.shrubberyOptions.map((option) => (
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
                        >
                            {allOptions.distanceOptions.map((option) => (
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
                        >
                            {allOptions.disturbanceOptions.map((option) => (
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
                        >
                            {allOptions.roadsOptions.map((option) => (
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
                        >
                            {allOptions.agricultureOptions.map((option) => (
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
                        >
                            {allOptions.grazingOptions.map((option) => (
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
                        >
                            {allOptions.grassRemovingOptions.map((option) => (
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
                        >
                            {allOptions.predatorsOptions.map((option) => (
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
                        >
                            {allOptions.protectionOptions.map((option) => (
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
                        >
                            {allOptions.purposeOptions.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                {option.label}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>
            </form>
        </div>
    )



}
export default CreateAntropologicalFactors