import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'

export default function ViewUser() {
    const { id } = useParams()

    const [users, setusers] = useState([]);
    useEffect(() => {
        loadUsers();
    }, []);
    const loadUsers = async () => {
        const result = await axios.get(`http://localhost:8080/user/${id}`)
        setusers(result.data);
    }

    return (
        <div className="container mx-auto mt-10">
            <div className="p-10 shadow-inner hover:shadow-2xl rounded-3xl mx-auto">
                <span className='text-4xl font-medium'>Details of user</span>

                <div className="details mt-10 mb-10 shadow-lg rounded-lg p-2">
                    <p><span className='text-2xl font-medium'>Name = </span><span className='text-xl'>{users.name}</span></p> <br />
                    <p><span className='text-2xl font-medium'>Email = </span><span className='text-xl'>{users.email}</span></p> <br />
                    <p><span className='text-2xl font-medium'>Username = </span><span className='text-xl'>{users.username}</span></p>
                </div>
                <Link to="/" className="relative inline-flex items-center justify-center p-0.5 mb-2 me-2 overflow-hidden text-sm font-medium text-gray-900 rounded-lg group bg-gradient-to-br from-purple-600 to-blue-500 group-hover:from-purple-600 group-hover:to-blue-500 hover:text-white dark:text-white focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800">
                    <span className="relative px-5 py-2.5 transition-all ease-in duration-75 bg-white dark:bg-gray-900 rounded-md group-hover:bg-opacity-0">
                        Back to Home
                    </span>
                </Link>
            </div>


        </div>
    )
}
