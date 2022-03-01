import React from "react";
import LoginPage from "../../view/components/login-page/login-page";
import Keuzemenu from "../../view/components/keuzemenu/keuzemenu";

const routes = {
    "/": () => <LoginPage/>,
    "menu": () => <Keuzemenu/>
};

export default routes;