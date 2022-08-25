import React, {useState, useEffect} from 'react';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';

export const ModalStyle = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 500,
    bgcolor: 'background.paper',
    border: '1px solid #000',
    boxShadow: 24,
    borderRadius: 10,
    p: 4,
  };


const Recommendations = props => {

    useEffect(()=>{
        // console.log(props.recommendations)
    }, [props])

    const handleClose = () => {
        props.closeModal();
    };
    return (
      <div className="container">
        <Modal
          open={props.open}
          onClose={handleClose}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <Box sx={ModalStyle} className="box">
            <div className="titles">
                <Typography id="modal-modal-title" variant="h4" component="h2">
                  Preporučene akcije za {props.name}
                </Typography>
                <Typography id="modal-modal-title" variant="h6" component="h2">
                    {props.message}
                </Typography>
            </div>
            <div>
                {props.recommendations.map((recommendation, index) => (
                    <ul>
                        <li>{recommendation.label}</li>
                    </ul>
                ))}
            </div>
          </Box>
        </Modal>
      </div>
    );
}
export default Recommendations
