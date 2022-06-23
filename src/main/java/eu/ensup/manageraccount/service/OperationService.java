package eu.ensup.manageraccount.service;

import eu.ensup.manageraccount.entity.Operation;
import eu.ensup.manageraccount.entity.TypeOperation;
import eu.ensup.manageraccount.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OperationService
{
    @Autowired
    private OperationRepository operationRepository;
    
    public List<Operation> findAll()
    {
        return operationRepository.findAll();
    }

    public List<Operation> findByTypeOperation(TypeOperation typeOperation)
    {
        return operationRepository.findByTypeOperation(typeOperation);
    }

    public List<Operation> findByAccount(int id)
    {
        return operationRepository.findByAccount(id);
    }

    public Operation findById(int id)
    {
        return operationRepository.findById(id).orElse(null);
    }

    public Operation save(Operation operation)
    {
        return operationRepository.save(operation);
    }

    public boolean delete(Operation operation)
    {
        operationRepository.delete(operation);
        return operationRepository.findById(operation.getId()).orElse(null) == null;
    }

    public boolean deleteById(int id)
    {
        operationRepository.deleteById(id);
        return operationRepository.findById(id).orElse(null) == null;
    }
}
