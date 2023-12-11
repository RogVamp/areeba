import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import CustomerService from '../services/CustomerService';

const ListCustomerComponent = () => {

  const [customerArray, setCustomerArray] = useState([])

  useEffect(()=>{
    getAllCustomers();

  },[]);

  function getAllCustomers(){
    CustomerService.getAllCustomer()
    .then(res=>{setCustomerArray(res.data); console.log(res)})
    .catch(e=>console.log(e));
  }

  function deleteCustomer(e, id){
    e.preventDefault();
    CustomerService.deleteCustomer(id)
    .then(getAllCustomers())
    .catch(e=>{console.log(e)});
  }

  return (
    <div className='container'>
        <Link to={"/add-customer"} className='btn btn-primary mb-2 mt-3' href="">Add Customer</Link>
        <h2 className='text-center mb-4'>List Customer</h2>
        <table className='table table-bordered table striped'>
            <thead>
              <tr>
                <th>Customer ID</th>
                <th>Customer First Name</th>
                <th>Customer Last Name</th>
                <th>Customer Address</th>
                <th>Customer Phone Number</th>
                <th>Customer Email</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
                {customerArray.map(customer=>
                  <tr key={customer.id} id={customer.id}>
                    <td>{customer.id}</td>
                    <td>{customer.firstName}</td>
                    <td>{customer.lastName}</td>
                    <td>{customer.address}</td>
                    <td>{customer.phoneNumber}</td>
                    <td>{customer.email}</td>
                    <td>
                      <Link to={`/add-customer/${customer.id}`} className="btn btn-info">Update</Link> {" "}
                      <a onClick={(e)=>{deleteCustomer(e, customer.id)}} className="btn btn-danger">Delete</a>
                    </td>

                  </tr>
                  )}
            </tbody>
        </table>
    </div>
  )
}

export default ListCustomerComponent