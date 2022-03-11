import React from "react";

function NavigeerMetProps(path, props){

    this.data = props;

    this.data.props.history.push('/' + path, {
        foo:'bar'
    })

}

export default NavigeerMetProps();