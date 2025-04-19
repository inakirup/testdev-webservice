export const searchPolicies = async (requestData) => {
    const response = await fetch('http://localhost:8080/api/policy/retrieve', {
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