import {registerPlugin} from '@capacitor/core';

export interface StreamaxiaPlugin {
  startCamera(options: void): Promise<void>;
  stopCamera(options: void): Promise<void>;
  startPublish(options: void): Promise<void>;
  stopPublish(options: void): Promise<void>;
}

const Streamaxia = registerPlugin<StreamaxiaPlugin>('Streamaxia');
export default Streamaxia;
