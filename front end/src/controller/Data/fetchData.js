import {useEffect, useState} from "react";
import axios from "axios";

export default function fetchData(pathParam, url) {
    const [data, setData] = useState({data: []});
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    useEffect(() => {
        const ac = new AbortController();

        if (pathParam !== undefined ) {
            if (pathParam === false || pathParam !== "") {

                setLoading(true);
                axios
                    .get(url, {signal: ac.signal})
                    .then((response) => {
                        setData(response.data);
                    })
                    .catch((err) => {
                        setError(err);
                    })
                    .finally(() => {
                        setLoading(false);
                        return () => ac.abort();
                    });
            }
        }
    }, [pathParam, url]);

    return {data, loading, error};
}
