import React from 'react';
import ReactDOM from 'react-dom/client';
import { Route, BrowserRouter, Routes } from 'react-router-dom';
import { Homepage } from './page/homepage';
import { Transaction } from './page/transaction';

ReactDOM.createRoot(document.getElementById("root")).render(
    <React.StrictMode>
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Homepage />} />
                <Route path="/history" element={<Transaction />} />
            </Routes>
        </BrowserRouter>
    </React.StrictMode>
);