import {IonButton, IonContent, IonHeader, IonPage, IonTitle, IonToolbar} from '@ionic/react';
import ExploreContainer from '../components/ExploreContainer';
import './Tab1.css';
import Echo from "../plugins/Echo";
import {Capacitor} from "@capacitor/core";
import Streamaxia from "../plugins/Streamaxia";
import {useState} from "react";

const Tab1: React.FC = () => {
  const [isStartedCamera, setIsStartedCamera] = useState<boolean>(false);
  const [isStartedPublish, setIsStartedPublish] = useState<boolean>(false);

  const startCameraBtnHandler = async () => {
    if (Capacitor.getPlatform() === 'android') {
      Streamaxia.startCamera();
      setIsStartedCamera(true);

    }
  }

  const stopCameraBtnHandler = async () => {
    if (Capacitor.getPlatform() === 'android') {
      Streamaxia.stopCamera();
      setIsStartedCamera(false);
      setIsStartedPublish(false);
    }
  }

  const startPublishHandler = async () => {
    if (Capacitor.getPlatform() === 'android') {
      Streamaxia.startPublish();
      setIsStartedPublish(true);
    }
  }
  const stopPublishHandler = async () => {
    if (Capacitor.getPlatform() === 'android') {
      Streamaxia.stopPublish();
      setIsStartedPublish(false);
    }
  }

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Tab 1</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">Tab 1</IonTitle>
          </IonToolbar>
        </IonHeader>
        {/*<ExploreContainer name="Tab 1 page"/>*/}
        {!isStartedCamera &&
          <IonButton style={{width: '100%'}} color="primary" onClick={startCameraBtnHandler}>Start Camera</IonButton>}
        {isStartedCamera &&
          <IonButton style={{width: '100%'}} color="primary" onClick={stopCameraBtnHandler}>Stop Camera</IonButton>}

        {isStartedCamera && !isStartedPublish &&
          <IonButton style={{width: '100%'}} color="primary" onClick={startPublishHandler}>Start Public</IonButton>}
        {isStartedPublish &&
          <IonButton style={{width: '100%'}} color="primary" onClick={stopPublishHandler}>Stop Public</IonButton>}
      </IonContent>
    </IonPage>
  );
};

export default Tab1;
