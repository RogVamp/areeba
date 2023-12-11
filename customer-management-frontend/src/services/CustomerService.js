import axios from "axios";

const BASE_URL = "http://localhost:8081/customer";

class CustomerService {

    //** Method to get all customers from our Api **//
    getAllCustomer(){
        return axios.get(BASE_URL);
    }
    //** Method to save customer **//
    saveCustomer(customerData){
        return axios.post(BASE_URL, customerData);
    }
    //** Method to update customer **//
    updateCustomer(id, customerData){
        return axios.put(`${BASE_URL}/${id}`, customerData)
    }
    //** Method to get customer by id **//
    getCustomerById(id){
        return axios.get(`${BASE_URL}/${id}`, id)
    }
    //** Method to delete customer **//
    deleteCustomer(id){
        return axios.delete(`${BASE_URL}/${id}`, id)
    }
}

export default new CustomerService();