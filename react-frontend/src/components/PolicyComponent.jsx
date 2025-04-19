import React, { useState } from 'react';
import { searchPolicies } from '../services/PolicyService';
import './PolicyComponent.css'; // Create this CSS file for animations

const PolicyComponent = () => {
  const [insuredName, setInsuredName] = useState('');
  const [response, setResponse] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!insuredName.trim()) return;

    setLoading(true);
    setError('');
    setResponse(null);

    try {
      const requestData = {
        headerData: {
          messageId: `MSG-${Date.now()}`,
          sendDateTime: new Date().toISOString()
        },
        requestRecord: {
          insureName: insuredName
        }
      };

      const result = await searchPolicies(requestData);

      if (result?.responseRecord?.policy) {
        const policiesArray = result.responseRecord.policy.map(p => ({
          policyNo: p.policyNo,
          status: p.status,
          agentD: p.agenID
        }));
        result.responseRecord.policies = policiesArray;
      }

      setResponse(result);
    } catch (err) {
      setError('Failed to fetch policy data. Please try again.');
      console.error('API Error:', err);
    } finally {
      setLoading(false);
    }
  };

  // Safe data access
  const policies = response?.responseRecord?.policies || [];
  const hasPolicies = policies.length > 0;
  const isError = response?.responseStatus?.status === 'E';
  const headerData = response?.headerData || {};

  return (
    <div className="policy-search-container">
      <div className="policy-card">
        <div className="card-header">
          <h3>Insurance Policy Lookup</h3>
        </div>

        <div className="card-body">
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label htmlFor="insuredName">Insured Name</label>
              <div className="input-group">
                <input
                  type="text"
                  id="insuredName"
                  value={insuredName}
                  onChange={(e) => setInsuredName(e.target.value)}
                  placeholder="Enter insured name"
                  required
                />
                <button type="submit" disabled={loading}>
                  {loading ? (
                    <>
                      <span className="spinner"></span>
                      Searching...
                    </>
                  ) : 'Search'}
                </button>
              </div>
            </div>
          </form>

          {error && (
            <div className="alert error">
              {error}
            </div>
          )}

          {response && (
            <div className="results-container">
              <h4>Policy Information</h4>

              {isError ? (
                <div className="alert warning">
                  <strong>Error:</strong> {response.responseStatus.errorMessage}
                </div>
              ) : hasPolicies ? (
                <div className="table-container">
                  <table>
                    <thead>
                      <tr>
                        <th>Policy No</th>
                        <th>Status</th>
                        <th>Agent ID</th>
                      </tr>
                    </thead>
                    <tbody>
                      {policies.map((policy, index) => (
                        <tr key={index}>
                          <td>{policy.policyNo}</td>
                          <td>
                            <span className={`badge ${policy.status === 'A' ? 'success' : 'warning'}`}>
                              {policy.status === 'A' ? 'Active' : 'Inactive'}
                            </span>
                          </td>
                          <td>{policy.agentD}</td>
                        </tr>
                      ))}
                    </tbody>
                  </table>
                </div>
              ) : (
                <div className="alert info">
                  No policies found for this insured name
                </div>
              )}

              {headerData.messageId && (
                <div className="meta-info">
                  <p><strong>Request ID:</strong> {headerData.messageId}</p>
                  <p><strong>Response Time:</strong> {new Date(headerData.responseDateTime).toLocaleString()}</p>
                </div>
              )}
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default PolicyComponent;