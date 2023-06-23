import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import ViewAllUsers from './AdminComponents/ViewAllUsers';
import AddUsers from './AdminComponents/AddUsers';
import UpdateUsers from './AdminComponents/UpdateUsers';
import DeleteUsers from './AdminComponents/DeleteUsers';
import FindById from './AdminComponents/FindById';
import FindByName from './AdminComponents/FindByName';
import FindByEmail from './AdminComponents/FindByEmail';
import FindByPhone from './AdminComponents/FindByPhone';
import ViewAllTasks from './UserComponents/ViewAllTasks';
import AddTasks from './UserComponents/AddTasks';
import UpdateTasks from './UserComponents/UpdateTasks';
import DeleteTasks from './UserComponents/DeleteTasks';
import FindTasksByName from './UserComponents/FindTasksByName';
import FinishedTasks from './UserComponents/FinishedTasks';
import NotFinishedTasks from './UserComponents/NotFinishedTasks';
import TasksSortedByDueDate from './UserComponents/TasksSoretedByDueDate';
import Home from './AdminComponents/Home';
import AdminLogin from './AdminComponents/AdminLogin';
import UserHome from './UserComponents/UserHome';
import UserService from './UserComponents/UserService';
import AdminUserServices from './AdminComponents/AdminUserService';

function App() {
  return (
    <BrowserRouter>


      <div className='container'>
        <div className="Container">
          <Routes>
            
            <Route path="" element={<AdminLogin />} />
            <Route path="/Admin/home" element={<Home />} />
            <Route path="/AdminUserService" element={<AdminUserServices />} />
            <Route path="/addUser" element={<AddUsers />} />
            <Route path="/updateUser" element={<UpdateUsers />} />
            <Route path="/viewallusers" element={<ViewAllUsers />} />
            <Route path="/deleteUser" element={<DeleteUsers />} />
            <Route path="/getUserById" element={<FindById />} />
            <Route path="/getUserByName" element={<FindByName />} />
            <Route path="/getUserByEmail" element={<FindByEmail />} />
            <Route path="/getUserByPhoneNo" element={<FindByPhone />} />
            <Route path="/UserService" element={<UserService />} />
            <Route path="/UserHome" element={<UserHome />} />
            <Route path="/addtask" element={<AddTasks />} />
            <Route path="/updateTask" element={<UpdateTasks />} />
            <Route path="/alltasks" element={<ViewAllTasks />} />
            <Route path="/deleteTask" element={<DeleteTasks />} />
            <Route path="/findtasksbyname" element={<FindTasksByName />} />
            <Route path="/getfinishedtasks" element={<FinishedTasks />} />
            <Route path="/getnotfinishedtasks" element={<NotFinishedTasks />} />
            <Route path="/gettasksortedbyduedate" element={<TasksSortedByDueDate />} />
          </Routes>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
