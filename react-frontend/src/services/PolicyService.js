export const searchPolicies = async (requestData) => {
    const apiUrl = process.env.REACT_APP_API_URL || 'http://localhost:8080';

    const response = await fetch(`${apiUrl}/api/policy/retrieve`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(requestData)
    });

    if (!response.ok) {
        throw new Error('Network response was not ok');
    }

    return await response.json();
};