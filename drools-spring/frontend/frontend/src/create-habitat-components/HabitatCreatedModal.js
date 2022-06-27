import React, { useEffect } from 'react';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import Button from '@mui/material/Button'
import './style.css'


const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '1px solid #000',
    boxShadow: 24,
    borderRadius: 10,
    p: 4,
  };

const HabitatCreatedModal = props => {


    const handleClose = () => {
        props.closeModal();
    }
  
    return (
      <div className="container">
        <Modal
          open={props.open}
          onClose={handleClose}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <Box sx={style}>
            <Typography id="modal-modal-title" variant="h6" component="h2">
              {props.title}
            </Typography>
            <Typography id="modal-modal-title" variant="h6" component="h5">
              {props.subtitle}
            </Typography>
            <div>
                <Button variant="outlined" className="bttn" onClick={handleClose}>OK</Button>
            </div>
          </Box>
        </Modal>
      </div>
    );
}
export default HabitatCreatedModal
