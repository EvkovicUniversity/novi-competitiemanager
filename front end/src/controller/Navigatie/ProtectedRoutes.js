import React from "react";
import {Navigate, Outlet, useLocation} from "react-router-dom";
import AuthService from "../../services/auth.service";

const useAuth = () => {
    return AuthService.getCurrentUser() !== null;
};

const ProtectedRoutes = () => {
    const location = useLocation();
    const isAuth = useAuth();
    return isAuth ? (
        <Outlet/>
    ) : (
        <Navigate to="/" replace state={{from: location}}/>
    );
};

export default ProtectedRoutes;