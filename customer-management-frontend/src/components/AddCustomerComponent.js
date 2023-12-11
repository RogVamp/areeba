import React, { useEffect, useState } from 'react'
import CustomerService from '../services/CustomerService';
import { useNavigate, Link, useParams } from 'react-router-dom';

const AddCustomerComponent = () => {

    /* Variables and methods to collect and store inputs */
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [address, setAddress] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const [email, setEmail] = useState('');
    const navigate = useNavigate();
    const {id} = useParams();

    const customerData = {firstName, lastName, email};
    
    function saveCustomer(e){
        e.preventDefault();
        if(customerData.firstName !== "" && customerData.lastName !== "" && customerData.email !== ""){
            if(id){
                CustomerService.updateCustomer(id, customerData)
                .then(navigate("/customer"))
                .catch(e=>console.log(e));
            } else {
                CustomerService.saveCustomer(customerData)
                .then(navigate("/customer"))
                .catch(e=>console.log(e));
            }
        } else {
            alert("Please, fill in all inputs")
        }
    }

    function title(){
        if(id){
            return "Update Customer"
        } else {
            return "Add Customer"
        }
    }

    useEffect(()=>{
        if(id){
            CustomerService.getCustomerById(id)
            .then(res=>{
                setFirstName(res.data.firstName);
                setLastName(res.data.lastName);
                setEmail(res.data.email);
            })
            .catch(e=>{console.log(e); alert(e);})
        }
        
    },[])

    return (
        <div>
            <div className='container mt-5'>
                <div className='row'>
                    <div className='card col-md-6 offset-md-3'>
                        <h2 className='text-center'>{title()}</h2>
                        <div className='card-body'>
                            <form>
                                <div className='form-group mb-2'>
                                    <input className='form-control' 
                                    value={firstName}
                                    onChange={(e)=>setFirstName(e.target.value)}
                                    type="text" placeholder='Enter First Name' />
                                </div>
                                <div className='form-group mb-2'>
                                    <input className='form-control' 
                                    value={lastName}
                                    onChange={(e)=>setLastName(e.target.value)}
                                    type="text" placeholder='Enter Last Name' />
                                </div>
                                <div className='form-group mb-2'>
                                    <input className='form-control' 
                                    value={address}
                                    onChange={(e)=>setAddress(e.target.value)}
                                    type="text" placeholder='Enter Address' />
                                </div>
                                <div className='form-group mb-2'>
                                    <input className='form-control' 
                                    value={phoneNumber}
                                    onChange={(e)=>setPhoneNumber(e.target.value)}
                                    type="text" placeholder='Enter Phone Number' />
                                </div>
                                <div className='form-group mb-2'>
                                    <input className='form-control' 
                                    value={email}
                                    onChange={(e)=>setEmail(e.target.value)}
                                    type="email" placeholder='Enter Email' />
                                </div>
                                <button onClick={(e)=>saveCustomer(e)} className='btn btn-success'>Save</button> {" "}
                                <Link to={"/customer"} className='btn btn-danger'>Cancel</Link>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default AddCustomerComponent